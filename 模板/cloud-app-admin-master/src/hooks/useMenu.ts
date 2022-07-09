import { IMenu } from "#/menu";
import router from "@/router";
import {
  RouteLocationNormalized,
  RouteLocationNormalizedLoaded,
  RouteRecordNormalized,
  RouteRecordRaw
} from "vue-router";
import { useStorage } from "@vueuse/core";
import { CacheEnum } from "@/enum/cacheEnum";

class Menu {
  public menus = ref<IMenu[]>([]);
  public history = useStorage<IMenu[]>(CacheEnum.HISTORY_MENU, []);
  public route = ref(null as null | RouteLocationNormalized);
  public close = useStorage<boolean>(CacheEnum.MENU_CLOSE_STATE, false);

  constructor() {
    this.menus.value = this.getMenuByRoute();
    this.history.value = this.getHistoryMenu();
  }

  removeHistoryMenu(menu: IMenu) {
    const index = this.history.value.indexOf(menu);
    this.history.value.splice(index, 1);
  }

  addHistoryMenu(route: RouteLocationNormalized) {
    if (!route.meta?.menu) return;
    this.route.value = route;

    const menu: IMenu = { ...route.meta?.menu, route: route.name as string };
    const isHas = this.history.value.some((menu) => menu.route == route.name);
    if (!isHas) this.history.value.unshift(menu);
    if (this.history.value.length > 10) {
      this.history.value.pop();
    }
  }

  private getHistoryMenu() {
    const routes = [] as RouteRecordRaw[];
    router.getRoutes().map((r) => routes.push(...r.children));

    return this.history.value.filter((m) => {
      return routes.some((r) => r.name == m.route);
    });
  }

  /**
   * 获取嵌套路由的面包屑
   * @param m 菜单对象
   * @param routerMap 用于存储路由名称对应的面包屑名称
   * @param title 用于连接面包屑名称
   */
  getNestedMenuByRoute(m: IMenu, routerMap: Map<string, string>, title = "") {
    m.children?.forEach((c) => {
      title !== "" ? (title = `${title}-${c.title}`) : (title = `${m.title}-${c.title}`);
      routerMap.set(c.route!, title);
      if (c.children) {
        this.getNestedMenuByRoute(c, routerMap, title);
      } else {
        title = "";
      }
    });
  }

  getCurrentMenu(route: RouteLocationNormalizedLoaded) {
    const routerMap = new Map();
    this.menus.value.forEach((m) => {
      this.getNestedMenuByRoute(m, routerMap);
    });
    return routerMap.get(route.name);
  }

  linkPage(menu: IMenu) {
    this.isExternalLink(menu) ? window.open(menu.path) : router.push({ name: menu.route });
  }

  isExternalLink(menu: IMenu) {
    return !!menu.path;
  }

  toggleState() {
    this.close.value = !this.close.value;
  }

  /**
   * 组装嵌套菜单对象
   * @param children 嵌套的子菜单
   * @returns 嵌套菜单对象
   */
  filterNestedMenu(children: RouteRecordNormalized["children"]): IMenu[] {
    return children
      .filter((route) => route.meta?.menu)
      .map((route) => {
        if (route.children) {
          const childRoute = this.filterNestedMenu(route.children);
          return { ...route.meta?.menu, route: route.name, children: childRoute };
        }
        return { ...route.meta?.menu, route: route.name };
      }) as IMenu[];
  }

  // 根据路由元数据构建菜单列表
  getMenuByRoute() {
    return router
      .getRoutes()
      .filter((route) => route.children.length && route.meta.menu && !route.meta.menu.nested)
      .map((route) => {
        const menu: IMenu = { ...route.meta?.menu };
        menu.children = this.filterNestedMenu(route.children);
        return menu;
      })
      .filter((menu) => menu.children?.length) as IMenu[];
  }
}

export default new Menu();
