
function func($this){	
	var boxA = document.getElementById("boxA");
	if($this.innerText=="停止"){
		boxA.style.animationPlayState="paused";
		$this.innerText="开始";
	}else{
		boxA.style.animationPlayState="running";
		$this.innerText="停止";
	}
	
};

function fast($this){
	var boxA = document.getElementById("boxA");
	boxA.style.animationDuration=".2s"
};

function slow($this){
	var boxA = document.getElementById("boxA");
	boxA.style.animationDuration=".8s"
}

function nomal($this){
	var boxA = document.getElementById("boxA");
	boxA.style.animationDuration=".5s"
}