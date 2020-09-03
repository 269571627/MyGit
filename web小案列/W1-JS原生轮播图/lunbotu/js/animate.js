//封装animate函数

function getStyle(obj,attr){			//获取样式
			if(obj.currentStyle){
				return obj.currentStyle[attr];
			}
			else{
				return obj.getComputedStyle(obj,null)[attr]
			}
}

function animate(obj,json,callback){
	clearInterval(obj.timer);		//控制多次点击不重定义定时器
	obj.timer=setInterval(function(){
		var isStop=true;			//判断是否所有运动完成
		for(var attr in json){
			var now=0;
			if(attr=='opacity'){
				now=parseInt(getStyle(obj,attr)*100)
			}
			else{
				now=parseInt(getStyle(obj,attr))
			}
			
			
			var speed=(json[attr]-now)/6;
			if(speed>0){
				speed=Math.ceil(speed);
			}else{
				speed=Math.floor(speed);
			}
			var current=now+speed;
			
			if(attr=='opacity'){
				obj.style[attr]=current/100;
			}
			else{
				obj.style[attr]=current+'px';
			}
	
			if (json[attr] != current) {	//任意一个定义的最后的动画值与当前值不等，不停止移动
				isStop=false;
			} 
		}
		if(isStop==true){
			clearInterval(obj.timer);	//动画完成清除定时器
			if(callback){
				callback();
			};
		}
	},0.1)
}