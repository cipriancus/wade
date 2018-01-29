//Flot Pie Chart
var baseURL="https://cryma.cfapps.io/api/"

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
            url: "https://cryma-plot.cfapps.io/coin",
            contentType: 'application/json;charset=UTF-8',
            success: function (values) {
				values=values._embedded.coin;
			
				var data=[];
				
				for(var iterator=0;iterator<values.length;iterator++){
					$("#cryptocurencyTop-dataTable tbody").append(`
										<tr class=\"odd gradeX\">
										<td class=\"center\">0</td>
                                        <td class=\"center\"><a href="bitcoin.html">`+values[iterator].name+`</a></td>
                                        <td class=\"center\">`+values[iterator].price+`</td>
                                        <td class=\"center\">`+values[iterator].marketCap+`</td>
                                        <td class=\"center\">`+values[iterator].volume+`</td>
										<td class=\"center\">`+values[iterator].supply+`</td>
										<td class=\"center\">`+values[iterator].change+`</td>
										</tr>`);
				}
			}
        });
});

$(function() {
   
     Morris.Area({
        element: 'topCryptocurrenciesGrowth',
        data: [{
            period: '2010 Q1',
            Bitcoin: 2666,
            Etherium: null,
            Btcash: 2647
        }, {
            period: '2010 Q2',
            Bitcoin: 2778,
            Etherium: 2294,
            Btcash: 2441
        }, {
            period: '2010 Q3',
            Bitcoin: 4912,
            Etherium: 1969,
            Btcash: 2501
        }, {
            period: '2010 Q4',
            Bitcoin: 3767,
            Etherium: 3597,
            Btcash: 5689
        }, {
            period: '2011 Q1',
            Bitcoin: 6810,
            Etherium: 1914,
            Btcash: 2293
        }, {
            period: '2011 Q2',
            Bitcoin: 5670,
            Etherium: 4293,
            Btcash: 1881
        }, {
            period: '2011 Q3',
            Bitcoin: 4820,
            Etherium: 3795,
            Btcash: 1588
        }, {
            period: '2011 Q4',
            Bitcoin: 15073,
            Etherium: 5967,
            Btcash: 5175
        }, {
            period: '2012 Q1',
            Bitcoin: 10687,
            Etherium: 4460,
            Btcash: 2028
        }, {
            period: '2012 Q2',
            Bitcoin: 8432,
            Etherium: 5713,
            Btcash: 1791
        }],
        xkey: 'period',
        ykeys: ['Bitcoin', 'Etherium', 'Btcash'],
        labels: ['Bitcoin', 'Etherium', 'Bitcoin Cash'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });
});
