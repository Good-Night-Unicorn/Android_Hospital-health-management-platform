<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","padding":"60rpx","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250222/87b074c3c23b4b738a1652e8b483d13b.png) no-repeat center bottom / 100% 100% ","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
		<view :style='{"width":"100%","padding":"40rpx","position":"relative","borderRadius":"20rpx","background":"none","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">患者账号：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.huanzhezhanghao"  type="text"  class="uni-input" name="" placeholder="患者账号" />
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">密码：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">确认密码：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">患者姓名：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.huanzhexingming"  type="text"  class="uni-input" name="" placeholder="患者姓名" />
			</view>
            <view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","display":"flex","height":"auto"}' v-if="tableName=='huanzhe'"  @change="huanzhexingbieChange" :value="huanzhexingbieIndex" :range="huanzhexingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","borderColor":"#d0d0d0","color":"#74868B","flex":"1","borderWidth":"0 0 2rpx 0","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">年龄：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
            <view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" @tap="huanzhetouxiangTap" class="">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","margin":"0 40rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","margin":"0 40rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">患者电话：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.huanzhedianhua"  type="text"  class="uni-input" name="" placeholder="患者电话" />
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">住址：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.zhuzhi"  type="text"  class="uni-input" name="" placeholder="住址" />
			</view>
			<view :style='{"border":"none","margin":"0 0 40rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 40rpx","color":"#000000","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">家属电话：</view>
				<input :style='{"padding":"0px 24rpx","margin":"0px","borderColor":"#d0d0d0","color":"#000","borderRadius":"0","flex":"1","background":"none","borderWidth":"0 0 2rpx 0","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.jiashudianhua"  type="text"  class="uni-input" name="" placeholder="家属电话" />
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"8rpx","background":"linear-gradient(45deg, #3d4e81, #5753c9, #6e7ff3)","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                huanzhexingbieOptions: [],
                huanzhexingbieIndex: 0,
				ruleForm: {
                huanzhezhanghao: '',
                mima: '',
                huanzhexingming: '',
                xingbie: '',
                nianling: '',
                touxiang: '',
                huanzhedianhua: '',
                zhuzhi: '',
                jiashudianhua: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='huanzhe'){
                this.huanzhexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.huanzhexingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            huanzhexingbieChange(e) {
                    this.huanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.huanzhexingbieOptions[this.huanzhexingbieIndex]
            },
            huanzhetouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.huanzhezhanghao) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `huanzhe` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`huanzhe` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`huanzhe` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
					this.$utils.msg(`年龄应输入整数`);
					return
				}
				if((!this.ruleForm.touxiang) && `huanzhe` == this.tableName){
					this.$utils.msg(`头像不能为空`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.huanzhedianhua&&(!this.$validate.isMobile(this.ruleForm.huanzhedianhua))){
					this.$utils.msg(`患者电话应输入手机格式`);
					return
				}
				if((!this.ruleForm.zhuzhi) && `huanzhe` == this.tableName){
					this.$utils.msg(`住址不能为空`);
					return
				}
				if((!this.ruleForm.jiashudianhua) && `huanzhe` == this.tableName){
					this.$utils.msg(`家属电话不能为空`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.jiashudianhua&&(!this.$validate.isMobile(this.ruleForm.jiashudianhua))){
					this.$utils.msg(`家属电话应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
