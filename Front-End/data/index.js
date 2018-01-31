
$(function() {
	 $.ajax({
            type: "GET",
            url: "https://cryma-plot.cfapps.io/coin",
            contentType: 'application/json;charset=UTF-8',
            success: function (values) {
				values=values._embedded.coin;
			
			var data=[];
			
			for(var iterator=0;iterator<values.length;iterator++){
				var instance={};
				instance['label']=values[iterator].name;
				instance['data']=values[iterator].marketCap;
				data.push(instance);
			}

				var plotObj = $.plot($("#distributionOfMainCryptocurrencies"), data, {
					series: {
						pie: {
							show: true
						}
					},
					grid: {
						hoverable: true
					},
					tooltip: true,
					tooltipOpts: {
						content: "%p.0%, %s",
						shifts: {
							x: 20,
							y: 0
						},
						defaultTheme: false
					}
				});
            }
        });
});

$(function() {
	 $.ajax({
            type: "GET",
            url: "https://cryma-news.cfapps.io/news/?limit=25&format=JSON-LD",
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
});

$(function() {
	//https://cryma-plot.cfapps.io/coin
	 $.ajax({
            type: "GET",
            url: "https://cryma-plot.cfapps.io/coin",
            contentType: 'application/json;charset=UTF-8',
            success: function (values) {
				values=values._embedded.coin;
			
				var data=[];
				
				for(var iterator=0;iterator<values.length;iterator++){
					$("#cryptocurencyTop-dataTable tbody").append(`
										<tr class=\"odd gradeX\">
										<td class=\"center\">`+iterator+`</td>
                                        <td class=\"center\"><a href="coin.html?id=`+values[iterator].id+`">`+values[iterator].name+`</a></td>
                                        <td class=\"center\">`+values[iterator].price+`</td>
                                        <td class=\"center\">`+values[iterator].marketCap+`</td>
                                        <td class=\"center\">`+values[iterator].volume+`</td>
										<td class=\"center\">`+values[iterator].supply+`</td>
										<td class=\"center\">`+values[iterator].change+`</td>
										</tr>`);
				}
				
				 $(document).ready(function() {
					$('#cryptocurencyTop-dataTable').DataTable({
						responsive: true
					});
				});
				}
        });
});

$(function() {
   
     Morris.Area({
        element: 'topCryptocurrenciesGrowth',
        data: [{
            period: '2017-10-24',
            Bitcoin: 5500,
            Etherium: 300,
            Btcash: 500
        }, {
            period: '2017-11-24',
            Bitcoin: 9000,
            Etherium: 500,
            Btcash: 1500
        }, {
            period: '2017-12-24',
            Bitcoin: 19000,
            Etherium: 800,
            Btcash: 3500
        }],
        xkey: 'period',
        ykeys: ['Bitcoin', 'Etherium', 'Btcash'],
        labels: ['Bitcoin', 'Etherium', 'Bitcoin Cash'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });
});
