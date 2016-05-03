var ComingSoon = function () {

    return {
        //main function to initiate the module
        init: function () {
            var austDay = new Date();
            austDay = new Date(austDay.getFullYear(), 3, 30);
            console.log(austDay);
            $('#defaultCountdown').countdown({until: austDay});
            $('#year').text(austDay.getFullYear());

            $.backstretch([
		            "/theme/assets/pages/media/bg/1.jpg",
		            "/theme/assets/pages/media/bg/2.jpg",
		            "/theme/assets/pages/media/bg/3.jpg",
		    		"/theme/assets/pages/media/bg/4.jpg"
		        ], {
		        fade: 1000,
		        duration: 10000
		   });
        }

    };

}();

jQuery(document).ready(function() {    
   ComingSoon.init(); 
});