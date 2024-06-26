function createChart(labels, data) {
  var ctx = document.getElementById("myBarChart");
  var myBarChart = new Chart(ctx, {
    type: 'horizontalBar',  // 수평 바 차트 사용
    data: {
      labels: labels,
      datasets: [{
        label: "재고 수량",
        backgroundColor: "#4e73df",
        hoverBackgroundColor: "#2e59d9",
        borderColor: "#4e73df",
        data: data,
      }],
    },
    options: {
      maintainAspectRatio: false,
      layout: {
        padding: {
          left: 10,
          right: 25,
          top: 25,
          bottom: 0
        }
      },
      scales: {
        xAxes: [{
          gridLines: {
            display: false,
            drawBorder: false
          },
          ticks: {
            maxTicksLimit: 10,
            beginAtZero: true,
            callback: function(value) { return number_format(value); }
          },
        }],
        yAxes: [{
          ticks: {
            maxTicksLimit: 10,
          },
          gridLines: {
            color: "rgb(234, 236, 244)",
            zeroLineColor: "rgb(234, 236, 244)",
            drawBorder: false,
            borderDash: [2],
            zeroLineBorderDash: [2]
          }
        }],
      },
      legend: {
        display: false
      },
      tooltips: {
        titleMarginBottom: 10,
        titleFontColor: '#6e707e',
        titleFontSize: 14,
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        caretPadding: 10,
        callbacks: {
          label: function(tooltipItem, chart) {
            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
            return datasetLabel + ': ' + number_format(tooltipItem.xLabel);
          }
        }
      },
    }
  });
}

document.addEventListener('DOMContentLoaded', function() {
  fetch('/admin/product/chart-data')
      .then(response => response.json())
      .then(data => {
        createChart(data.labels, data.data);
      })
      .catch(error => console.error('Error:', error));
});