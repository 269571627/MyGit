alert("closure")
//函数作为返回值
function create() {
    let a = 100
    return function () {
        console.log(a)
    }
}

let fn = create()
let a = 200
fn()


//函数作为参数
function print(fnb) {
    let b = 200
    fnb()
}

let b = 100

function fnb() {
    console.log(b)
}

print(fnb)