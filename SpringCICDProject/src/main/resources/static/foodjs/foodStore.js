const {defineStore} = Pinia

const useFoodStore = defineStore('food', {
	state: () => ({
		address: '마포',
		food_list: [],
		curpage: 1,
		totalpage: 0,
		startPage: 0,
		endPage: 0,
		food_detail: {},
		reply: [],
		type: 1,
		cno: 0,
		msg: '',
		sessionId: ''
	}),
	
	actions: {
		async dataRecv() {
			const res = await axios.get('http://localhost:8080/food/find_vue/', {
				params: {
					page: this.curpage,
					address: this.address
				}
			})
			
			console.log(res.data)
			this.food_list = res.data.list
			this.curpage = res.data.curpage
			this.totalpage = res.data.totalpage
			this.startPage = res.data.startPage
			this.endPage = res.data.endPage
		},
		
		find(addressRef) {
			if(this.address === '') {
				addressRef.focus()
				retrun
			}
			
			this.curpage = 1
			this.dataRecv()
		},
		
		pageChange(page) {
			this.curpage = page
			this.dataRecv()
		},
		
		range(start, end) {
			let arr = []
			let len = end - start
			
			for(let i=0;i<=len;i++) {
				arr[i] = start
				start++
			}
			
			return arr
		},
		
		async foodDetailData(fno) {
			const res = await axios.get('http://localhost:8080/food/detail_vue/', {
				params: {
					fno: fno
				}
			})
			console.log(res.data)
			this.food_detail = res.data
		},
		
		// 댓글
		async foodReplyData(cno) {
			const res = await axios.get('http://localhost:8080/reply/list_vue/', {
				params: {
					cno: cno,
					type: this.type
				}
			})
			
			console.log(res.data)
			this.reply = res.data.rList
			this.cno = res.data.cno
			this.sessionId = res.data.sessionId
		},
		
		async foodReplyInsert(cno, msgRef) {
			if (this.msg === '') {
				msgRef?.focus()
				return
			}
			
			const res = await axios.post('http://localhost:8080/reply/insert_vue/', {
				cno: cno,
				type: this.type,
				msg: this.msg
			})
			
			console.log(res.data)
			this.sessionId = res.data.sessionId
			this.reply = res.data.rList
			this.cno = res.data.cno
			this.msg = ''
			msgRef?.focus()
		}
	}
})






























