$(function(){
	var $width = $(window).width();
	$(".slider-pics img").width($width);
    $(".slider-circle").width($width);


    $("#menuBtn").on('click',function(){
		if(!$('#menuBtn').hasClass("open")){
			$("#menu").css({'display':'block','z-index':'10'});
			$("#menuBtn").addClass("open");
		}
		else{
			$("#menuBtn").removeClass("open");
			$("#menu").css({'display':'none'});
		}
		
    });
    
    function play(preIndex, currentIndex){
		$('.slider-pics').eq(preIndex).fadeOut(500)
		.parent().children().eq(currentIndex).fadeIn(1000);
		$('.slider-item').removeClass('slider-item-selected');
		$('.slider-item').eq(currentIndex).addClass('slider-item-selected');
    }	
    
    
    var currentIndex = 0;
    var length = $('.slider-pics').length;
    function pre(){
		var preIndex = currentIndex;
		currentIndex = (--currentIndex + length) % length;
		play(preIndex, currentIndex);
	}

	function next(){
		var preIndex = currentIndex;
		currentIndex = ++currentIndex % length;
		play(preIndex, currentIndex);
    }
    
    var interval, hasStarted = false;

	function start(){
		if(!hasStarted){
			hasStarted = true;
			interval = setInterval(next,3000);
		}
	}

	function stop(){
		clearInterval(interval);
		hasStarted = false;
	}

    start();
    
    $('.slider-pics:not(:first)').hide();
	$('.slider-item:first').addClass('slider-item-selected');
	$('.slider-button').hide();
	$('.slider-pics, .slider-pre, .slider-next').hover(function(){
		stop();
		$(".slider-button").show();
	},function(){
		$('.slider-button').hide();
		start();
	});
    
    
    $('.slider-item').hover(function(){
		stop();
		var preIndex = $(".slider-item").filter(".slider-item-selected").index();
		currentIndex = $(this).index();
		play(preIndex,currentIndex);
	},function(){
		start();
	});
    
    
    $('.slider-pre').on('click',function(){
		pre();
	});
	$('.slider-next').on('click',function(){
		next();
	});

    
})
