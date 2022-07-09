import { userStore } from "@/store/user";
import { Router, RouteRecordRaw } from "vue-router";
import autoloadModuleRoutes from "./module";

let routes: RouteRecordRaw[] = autoloadModuleRoutes();

/**
 * 收集嵌套路由元信息并组装
 * @param children 嵌套的子路由
 * @returns 路由元信息
 */
function filterNestedChildren(children: RouteRecordRaw[]) {
  const user = userStore();
  if (user.info?.permission === undefined) return children;

  return children.filter((r) => {
    const permissions = r.meta?.permissions;

    if (r.children) {
      r.children = filterNestedChildren(r.children);
    }

    return permissions ? permissions?.includes(user.info!.permission) : true;
  });
}

function autoload(router: Router) {
  routes = routes.map((route) => {
    route.children = filterNestedChildren(route.children!);
    return route;
  });
  routes.forEach((r) => router.addRoute(r));
}

export default autoload;
