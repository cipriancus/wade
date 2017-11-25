$(function() {

    Morris.Area({
        element: 'morris-area-chart',
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

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });
    
});
