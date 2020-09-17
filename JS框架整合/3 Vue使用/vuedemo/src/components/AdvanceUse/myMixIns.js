export default{
    data(){
        return{
            name:'mixins',
            classroom:'3班'
        }
    },
    methods:{
        showItem(){
           console.log(this.number,this.name,this.classroom)
        }
    },
    mounted(){
        console.log('mixins mounted')
    }
}