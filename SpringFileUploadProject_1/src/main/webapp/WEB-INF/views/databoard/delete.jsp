<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3.3.4/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
const NO = '${param.no}'
</script>
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 400px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">삭제하기</h3>
			<table class="table">
				<tbody>
					<tr>
						<td class="text-center">
							비밀번호 : <input type="password" class="input-sm" name="pwd" size="20" v-model="pwd" ref="pwd">
						</td>
					</tr>
					<tr>
						<td class="text-center">
							<button class="btn-sm btn-danger" @click="del()">삭제하기</button>
							<button class="btn-sm btn-danger" type="button" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<script>
	const app = Vue.createApp({
		data() {
			return {
				no: 0,
				pwd: ''
			}
		},
		
		mounted() {
			this.no = NO
		},
		
		methods: {
			del() {
				if (this.pwd === '') {
					this.$refs.pwd.focus()
					return
				}
				
				axios.delete('/databoard/delete_ok', {
					params: {
						no: this.no,
						pwd: this.pwd
					}
				}).then(response => {
					if (response.data === 'yes') {
						location.href = "/databoard/list"
					} else {
						alert('비밀번호가 틀립니다')
						this.pwd = ''
						this.$refs.pwd.focus()
					}
				})
			}
		}
	}).mount(".container")
</script>
</body>
</html>