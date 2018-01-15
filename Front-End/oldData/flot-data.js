//Flot Pie Chart
$(function() {

    var data = [{
        label: "Ripple",
        data: 6.6463299E9
    }, {
        label: "Bitcoin Cash",
        data: 6.8154199E9
    }, {
        label: "Etherium",
        data: 1.27662998E11
    }, {
        label: "Bitcoin",
        data: 2.37415006E11
    }];

    var plotObj = $.plot($("#flot-pie-chart"), data, {
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
            content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
            shifts: {
                x: 20,
                y: 0
            },
            defaultTheme: false
        }
    });

});