jQuery(document).ready(function($){
	let city_name = '';
	$('#btn-search').on('click' , function(e){
		e.preventDefault();
		
		city_name = $('input[name="cityname"]').val();
		
		console.log(window.location.origin);
		//console.log(city_name);
		if(city_name !== ''){
			$.ajax({
				method : 'GET',
				url : window.location.origin+'/get-city',
				data : {
					cityname : city_name
				},
				success : function(res){
					console.log(res);
					//location.reload();
					console.log(this.url);
					window.location.href = "get-city?cityname="+city_name;
				},
			});
		}
		
	});
	
	if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
  		window.location.href = window.location.origin;
	}
	
});