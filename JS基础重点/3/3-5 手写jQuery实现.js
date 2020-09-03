alert('jquery demo')
/**
 * jQuery对Dom查询
 */

 class jQuery{
    constructor(selector) {
        const result = document.querySelectorAll(selector)
        console.log("selector",selector,"result",result)
        const length = result.length
        for (let i = 0; i < length; i++){
            this[i] = result[i]
        }
        this.length = length
        console.log("构造了this类数组",this)
    }

    get(index){
        return this[index]
    }

    each(fn){
        for(let i = 0; i < this.length; i++){
            const elem = this[i]
            fn(elem)
        }
    }

    on(type,fn){
        return this.each(elem => {
            elem.addEventListener(type,fn,false)
        })
    }
 }
 // 插件 jQuer显式原型添加
 jQuery.prototype.sumfn= function(num1,num2){
     alert(num1+num2)
 }

 //复写  “造轮子”
 class myJquery extends jQuery{
     constructor(selector){
         super(selector)
     }
     //扩展自己的方法
     addClass(className){
         console.log("addClass",className)
     }
 }

 const $p = new myJquery('p')
 $p.get(1)
 $p.each((elem)=> console.log(elem))
 $p.on('click',() => alert('点点点'))

 $p.sumfn(33,40)
 $p.addClass(123)