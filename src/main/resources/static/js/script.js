$(function(){
	'use strict';
	//Slider
	var $owl = $('.owl');
	$owl.each( function() {
		var $a = $(this);
		$a.owlCarousel({
			transitionStyle: $a.attr('data-transitionstyle'),
			autoPlay:true,
			singleItem: JSON.parse($a.attr('data-singleItem')),
			items : $a.attr('data-items'),
			itemsDesktop : [1199,$a.attr('data-itemsDesktop')],
			itemsDesktopSmall : [992,$a.attr('data-itemsDesktopSmall')],
			itemsTablet:  [797,$a.attr('data-itemsTablet')],
			itemsMobile :  [479,$a.attr('data-itemsMobile')],
			navigation : JSON.parse($a.attr('data-buttons')),
			pagination: JSON.parse($a.attr('data-pag')),
			navigationText: ["",""],
			touchDrag: false,
			mouseDrag: false
		});
	});
	//Menu
	$('.menu-btn').on('click',function(e){
		//e.stopPropagation();		
		if($(this).hasClass('active'))
		{
			$('.menu-rs').animate({right: '-250px'},500);
		}
		else
		{
			$('.menu-rs').animate({right: '0px'},500);
		}
	});
	$('.r-mv').on('click',function(){
		$('.menu-rs').animate({right: '-250px'},500);
	});
	$(window).load(function()
	{
		$('.preloader i').fadeOut();
		$('.preloader').delay(500).fadeOut('slow');
		$('body').delay(600).css({'overflow':'visible'});
	});
	window.onresize = function()
	{
		ft();
	}
	//Header resize
	function ft(){
		$('.header-absolute').next().css('marginTop',($('.header-absolute').height())+'px');
	}
	ft();
	$('[data-toggle=popover]').popover({
		content: $('.list-icon').html(),
		html: true
	}).click(function() {
		$(this).popover();
	});
	$('header').removeClass('smaller');
	$('.main-header').removeClass('animated').removeClass('slideInUp').removeClass('slideInDown');
	window.addEventListener('scroll', function(e){
		var $header=$('.header-absolute .main-header');
		var $tr=$('.header-absolute').height();
		var distanceY = window.pageYOffset || document.documentElement.scrollTop,
			shrinkOn = $tr;
			var header = document.querySelector("header");
		if (distanceY > shrinkOn) {
			classie.add(header,"smaller");
			$header.removeClass('animated').removeClass('bounceInUp');
			$header.addClass('animated').addClass('slideInDown');
		} else {
			if (classie.has(header,"smaller")) {
				$header.removeClass('animated').removeClass('slideInDown');
				classie.remove(header,"smaller");
			}
		}
	});
});