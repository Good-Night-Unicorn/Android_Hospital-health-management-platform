<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="患者姓名" prop="huanzhexingming" >
					<el-input v-model="ruleForm.huanzhexingming" placeholder="患者姓名" clearable  :readonly="ro.huanzhexingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="患者姓名" prop="huanzhexingming" >
					<el-input v-model="ruleForm.huanzhexingming" placeholder="患者姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="时间" prop="shijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shijian" 
						type="date"
						:readonly="ro.shijian"
						placeholder="时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shijian" label="时间" prop="shijian" >
					<el-input v-model="ruleForm.shijian" placeholder="时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="身高(m)" prop="shengao" >
					<el-input v-model="ruleForm.shengao" placeholder="身高(m)" clearable  :readonly="ro.shengao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="身高(m)" prop="shengao" >
					<el-input v-model="ruleForm.shengao" placeholder="身高(m)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="体重(kg)" prop="tizhong" >
					<el-input v-model="ruleForm.tizhong" placeholder="体重(kg)" clearable  :readonly="ro.tizhong"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="体重(kg)" prop="tizhong" >
					<el-input v-model="ruleForm.tizhong" placeholder="体重(kg)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="左眼视力" prop="zuoyanshili" >
					<el-input v-model="ruleForm.zuoyanshili" placeholder="左眼视力" clearable  :readonly="ro.zuoyanshili"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="左眼视力" prop="zuoyanshili" >
					<el-input v-model="ruleForm.zuoyanshili" placeholder="左眼视力" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="右眼视力" prop="youyanshili" >
					<el-input v-model="ruleForm.youyanshili" placeholder="右眼视力" clearable  :readonly="ro.youyanshili"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="右眼视力" prop="youyanshili" >
					<el-input v-model="ruleForm.youyanshili" placeholder="右眼视力" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="血糖(mmol/L)" prop="xuetang" >
					<el-input v-model="ruleForm.xuetang" placeholder="血糖(mmol/L)" clearable  :readonly="ro.xuetang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="血糖(mmol/L)" prop="xuetang" >
					<el-input v-model="ruleForm.xuetang" placeholder="血糖(mmol/L)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="舒张压(kpa)" prop="shuzhangya" >
					<el-input v-model="ruleForm.shuzhangya" placeholder="舒张压(kpa)" clearable  :readonly="ro.shuzhangya"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="舒张压(kpa)" prop="shuzhangya" >
					<el-input v-model="ruleForm.shuzhangya" placeholder="舒张压(kpa)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="收缩压(kpa)" prop="shousuoya" >
					<el-input v-model="ruleForm.shousuoya" placeholder="收缩压(kpa)" clearable  :readonly="ro.shousuoya"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="收缩压(kpa)" prop="shousuoya" >
					<el-input v-model="ruleForm.shousuoya" placeholder="收缩压(kpa)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="患者账号" prop="huanzhezhanghao" >
					<el-input v-model="ruleForm.huanzhezhanghao" placeholder="患者账号" clearable  :readonly="ro.huanzhezhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="患者账号" prop="huanzhezhanghao" >
					<el-input v-model="ruleForm.huanzhezhanghao" placeholder="患者账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="年龄" prop="nianling" >
					<el-input v-model="ruleForm.nianling" placeholder="年龄" clearable  :readonly="ro.nianling"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="年龄" prop="nianling" >
					<el-input v-model="ruleForm.nianling" placeholder="年龄" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="性别" prop="xingbie" >
					<el-input v-model="ruleForm.xingbie" placeholder="性别" clearable  :readonly="ro.xingbie"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="性别" prop="xingbie" >
					<el-input v-model="ruleForm.xingbie" placeholder="性别" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.baogaotupian" label="报告图片" prop="baogaotupian" >
					<file-upload
						tip="点击上传报告图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.baogaotupian?ruleForm.baogaotupian:''"
						@change="baogaotupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.baogaotupian" label="报告图片" prop="baogaotupian" >
					<img v-if="ruleForm.baogaotupian.substring(0,4)=='http'&&ruleForm.baogaotupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.baogaotupian" width="100" height="100">
					<img v-else-if="ruleForm.baogaotupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.baogaotupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.baogaotupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					确定
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
				ro:{
					huanzhexingming : false,
					shijian : false,
					shengao : false,
					tizhong : false,
					zuoyanshili : false,
					youyanshili : false,
					xuetang : false,
					shuzhangya : false,
					shousuoya : false,
					huanzhezhanghao : false,
					nianling : false,
					xingbie : false,
					baogaotupian : false,
				},
			
				ruleForm: {
					huanzhexingming: '',
					shijian: '',
					shengao: '',
					tizhong: '',
					zuoyanshili: '',
					youyanshili: '',
					xuetang: '',
					shuzhangya: '',
					shousuoya: '',
					huanzhezhanghao: '',
					nianling: '',
					xingbie: '',
					baogaotupian: '',
				},

				rules: {
					huanzhexingming: [
					],
					shijian: [
					],
					shengao: [
					],
					tizhong: [
					],
					zuoyanshili: [
					],
					youyanshili: [
					],
					xuetang: [
					],
					shuzhangya: [
					],
					shousuoya: [
					],
					huanzhezhanghao: [
					],
					nianling: [
					],
					xingbie: [
					],
					baogaotupian: [
						{ required: true, message: '报告图片不能为空', trigger: 'blur' },
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.shijian = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='huanzhexingming'){
							this.ruleForm.huanzhexingming = obj[o];
							this.ro.huanzhexingming = true;
							continue;
						}
						if(o=='shijian'){
							this.ruleForm.shijian = obj[o];
							this.ro.shijian = true;
							continue;
						}
						if(o=='shengao'){
							this.ruleForm.shengao = obj[o];
							this.ro.shengao = true;
							continue;
						}
						if(o=='tizhong'){
							this.ruleForm.tizhong = obj[o];
							this.ro.tizhong = true;
							continue;
						}
						if(o=='zuoyanshili'){
							this.ruleForm.zuoyanshili = obj[o];
							this.ro.zuoyanshili = true;
							continue;
						}
						if(o=='youyanshili'){
							this.ruleForm.youyanshili = obj[o];
							this.ro.youyanshili = true;
							continue;
						}
						if(o=='xuetang'){
							this.ruleForm.xuetang = obj[o];
							this.ro.xuetang = true;
							continue;
						}
						if(o=='shuzhangya'){
							this.ruleForm.shuzhangya = obj[o];
							this.ro.shuzhangya = true;
							continue;
						}
						if(o=='shousuoya'){
							this.ruleForm.shousuoya = obj[o];
							this.ro.shousuoya = true;
							continue;
						}
						if(o=='huanzhezhanghao'){
							this.ruleForm.huanzhezhanghao = obj[o];
							this.ro.huanzhezhanghao = true;
							continue;
						}
						if(o=='nianling'){
							this.ruleForm.nianling = obj[o];
							this.ro.nianling = true;
							continue;
						}
						if(o=='xingbie'){
							this.ruleForm.xingbie = obj[o];
							this.ro.xingbie = true;
							continue;
						}
						if(o=='baogaotupian'){
							this.ruleForm.baogaotupian = obj[o];
							this.ro.baogaotupian = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.huanzhexingming!=''&&json.huanzhexingming) || json.huanzhexingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.huanzhexingming = json.huanzhexingming
							this.ro.huanzhexingming = true;
						}
						if(((json.huanzhezhanghao!=''&&json.huanzhezhanghao) || json.huanzhezhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.huanzhezhanghao = json.huanzhezhanghao
							this.ro.huanzhezhanghao = true;
						}
						if(((json.nianling!=''&&json.nianling) || json.nianling==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.nianling = json.nianling
							this.ro.nianling = true;
						}
						if(((json.xingbie!=''&&json.xingbie) || json.xingbie==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.xingbie = json.xingbie
							this.ro.xingbie = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `jiankangshuju/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.baogaotupian!=null) {
						this.ruleForm.baogaotupian = this.ruleForm.baogaotupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `jiankangshuju/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.jiankangshujuCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.jiankangshujuCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			baogaotupianUploadChange(fileUrls) {
				this.ruleForm.baogaotupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px 40px;
		width: 100%;
	}
	.add-update-preview {
		border-radius: 10px;
		padding: 40px 30% 40px 10%;
		background: #fff;
		width: 100%;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #6e6e6e;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #666;
		word-break: break-all;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		min-width: 100%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		min-width: 100%;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 15px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		width: 100%;
		text-align: left;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #4dc2de;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #2879f0;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #32c67a;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #98a58f;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #3fa2d1;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
