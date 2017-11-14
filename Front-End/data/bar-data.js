$(function() {
    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 20
        }, {
            y: '2007',
            a: 150,
            b: 30
        }, {
            y: '2008',
            a: 150,
            b: 30
        }, {
            y: '2009',
            a: 750,
            b: 65
        }, {
            y: '2010',
            a: 500,
            b: 40
        }, {
            y: '2011',
            a: 500,
            b: 165
        }, {
            y: '2012',
            a: 1000,
            b: 500
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });
	
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

});
