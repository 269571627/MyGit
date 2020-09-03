alert('deepClone')
/**
 * 深拷贝：改变引用类型中的值原来的不变
 */

 let object1 = {
     name:"zzz",
     age:22,
     address:{
         city:'cd'
     },
     arr:['1','d','*']
 }

 let object2 = deepClone(object1)
 object2.name = 'xl'
 object2.address.city = 'jintang'
 console.log("obj1",object1)

 function deepClone(obj){
     if(typeof(obj) !== 'object' || obj == null){
         console.log("obj",obj)
         return obj
     }
     
     let result
     if(obj instanceof Array){
        result = []
     }else{
        result = {}
     }

     //递归
     for(let key in obj){
        if(obj.hasOwnProperty(key)){
            result[key] = deepClone(obj[key])
        }
     }

     console.log("result",result)
     return result
 }