
var coin;
var check=false;

$(function() {
	 $.ajax({
            type: "GET",
            url: "https://cryma-plot.cfapps.io/coin/"+$.urlParam('id'),
            contentType: 'application/json;charset=UTF-8',
            success: function (value) {
			
			coin=value;
				
					$("#cryptocurencyTop-dataTable tbody").append(`
										<tr class=\"odd gradeX\">
										<td class=\"center\">0</td>
                                        <td class=\"center\"><a href="coin.html?id=`+value.id+`">`+value.name+`</a></td>
                                        <td class=\"center\">`+value.price+`</td>
                                        <td class=\"center\">`+value.marketCap+`</td>
                                        <td class=\"center\">`+value.volume+`</td>
										<td class=\"center\">`+value.supply+`</td>
										<td class=\"center\">`+value.change+`</td>
										</tr>`);
				
				$("#name").text(value.name);
				
				 $(document).ready(function() {
					$('#cryptocurencyTop-dataTable').DataTable({
						responsive: true
					});
				});
				}
        });
});

function news() {
	if(coin!=null&&check==false){
		 $.ajax({
				type: "GET",
				url: "https://cryma-news.cfapps.io/news/coin/"+coin.abbreviation+"?limit=25&format=JSON-LD",
				contentType: 'application/json;charset=UTF-8',
				success: function (values) {
				
				values=jQuery.parseJSON(values);
				
				values=values["@graph"];
								
				for(var iterator=0;iterator<values.length;iterator++){
					var info=values[iterator]["rs:value"];
					if(info!=null&&info.length<100){
						$("#newsBodyUL").append(`
					<li class="clearfix">
										<div class="chat-body clearfix">
											<div class="header">
												<strong class="primary-font">
							<a href="">`+info+`
							 </a></strong>
											</div>
										</div>
									</li>`);
					}
				}
			   }
			});
	}
}

 setTimeout(news, 1000);

function price() {
	if(coin!=null&&check==false){
		 $.ajax({
				type: "GET",
				url: "https://cryma-plot.cfapps.io/plot/"+coin.abbreviation+"?format=JSON-LD&startDate=2014-05-23T10:20:13%2B05:30&endDate=2019-05-23T10:20:13%2B05:30",
				contentType: 'application/json;charset=UTF-8',
				success: function (values) {
					
							values=jQuery.parseJSON(values);
							
							values=values["@graph"];
							
							var listValues=[];
											

							var date=[];
							var value=[];
							
							for(var iterator=0;iterator<values.length;iterator++){
								
								if(values[iterator]["rs:variable"]==="date"){//date
									
									if(values[iterator]["rs:value"]["@value"]!=null){
										date.push(values[iterator]["rs:value"]["@value"]);
									}else if(values[iterator]["value"]!=null){
										date.push(values[iterator]["rs:value"]);
									}
								}
							}
							
							for(var iterator=0;iterator<values.length;iterator++){
								
								if(values[iterator]["rs:variable"]==="price"){//date
									var price=values[iterator]["rs:value"];
									
									value.push(price);
								}
							}
							
							for(var iterator=0;iterator<date.length;iterator++){
								listValues.push([Date.parse(date[iterator]),value[iterator]]);
							}
					
							var barOptions = {
							series: {
								bars: {
									show: true,
									barWidth: 43200000
								}
							},
							xaxis: {
								mode: "time",
								minTickSize: [1, "day"]
							},
							grid: {
								hoverable: true
							},
							legend: {
								show: false
							},
							tooltip: true,
							tooltipOpts: {
								content: "x: %x, y: %y"
							}
						};
						
						var barData = {
							label: "bar",
							data: listValues
						};
						$.plot($("#price-evolution-chart"), [barData], barOptions);
				}
			});
	}
}

 setTimeout(price, 1000);

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return decodeURI(results[1]) || 0;
    }
}