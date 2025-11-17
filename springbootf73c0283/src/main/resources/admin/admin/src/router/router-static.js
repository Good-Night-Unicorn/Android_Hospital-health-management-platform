import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import jiankangfenlei from '@/views/modules/jiankangfenlei/list'
	import aboutus from '@/views/modules/aboutus/list'
	import huanzhe from '@/views/modules/huanzhe/list'
	import jiankangdangan from '@/views/modules/jiankangdangan/list'
	import jiankangshuju from '@/views/modules/jiankangshuju/list'
	import storeup from '@/views/modules/storeup/list'
	import jiankangshipin from '@/views/modules/jiankangshipin/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import discussjiankangwenzhang from '@/views/modules/discussjiankangwenzhang/list'
	import popupremind from '@/views/modules/popupremind/list'
	import chat from '@/views/modules/chat/list'
	import forumreport from '@/views/modules/forumreport/list'
	import config from '@/views/modules/config/list'
	import jiankangpinggu from '@/views/modules/jiankangpinggu/list'
	import jiankangwenzhang from '@/views/modules/jiankangwenzhang/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/jiankangfenlei',
		name: '健康分类',
		component: jiankangfenlei
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/huanzhe',
		name: '患者',
		component: huanzhe
	}
	,{
		path: '/jiankangdangan',
		name: '健康档案',
		component: jiankangdangan
	}
	,{
		path: '/jiankangshuju',
		name: '健康数据',
		component: jiankangshuju
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/jiankangshipin',
		name: '健康视频',
		component: jiankangshipin
	}
	,{
		path: '/forum',
		name: '健康社区',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/discussjiankangwenzhang',
		name: '健康文章评论',
		component: discussjiankangwenzhang
	}
	,{
		path: '/popupremind',
		name: '弹窗提醒',
		component: popupremind
	}
	,{
		path: '/chat',
		name: '健康咨询',
		component: chat
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/jiankangpinggu',
		name: '健康评估',
		component: jiankangpinggu
	}
	,{
		path: '/jiankangwenzhang',
		name: '健康文章',
		component: jiankangwenzhang
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
