alert("CLSS DEMO")
/**
 * 类： constructor  属性  方法
 * 
 * 继承： extends super 扩展和重写
 */


//父类
class People {
    constructor(name,id){
        this.name = name
        this.id = id
    }
    eat(){
        console.log(
            `饭卡号：姓名${this.name} id：${this.id}`
        )
    }
}

//子类
class Student extends People{
    constructor(name,id,room){
        super(name,id)
        this.room = room
    }
    sayHi(){
        console.log(
            `我是${this.name},学号是${this.id},班级${this.room}`
        )
    }
}

class Teacher extends People{
    constructor(name,id,room,major){
        super(name,id)
        this.room = room
        this.major = major
    }
    teach(){
        console.log(
            `教学办：老师：${this.name},id是${this.id},班级${this.room}，科目${this.major}`
        )
    }
}

//实例
const xialuo = new Student('夏洛','001','3班')
console.log(xialuo.name)
xialuo.sayHi()
xialuo.eat()


const teacher = new Teacher('王老师','9','21班','数学')
console.log(teacher)
teacher.teach()
teacher.eat()