<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biểu đồ danh mục</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        #chartContainer {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            height: 400px;
        }
    </style>
</head>
<body>
    <div id="chartContainer">
        <canvas id="chartCanvas"></canvas>
    </div>

    <script>
        // Gửi AJAX để lấy dữ liệu từ Servlet
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var jsonData = JSON.parse(xhr.responseText);

                // Chuẩn bị dữ liệu cho biểu đồ
                var labels = [];
                var data = [];

                // Lặp qua dữ liệu JSON để lấy tên danh mục và số lượng sản phẩm
                for (var i = 0; i < jsonData.length; i++) {
                    var category = jsonData[i];
                    labels.push(category.cname);  // Lấy tên danh mục
                    data.push(category.productCount);  // Lấy số lượng sản phẩm
                }

                // Vẽ biểu đồ hình tròn bằng thư viện Chart.js
                var ctx = document.getElementById('chartCanvas').getContext('2d');
                new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: labels,  // Gán tên danh mục
                        datasets: [{
                            data: data,  // Gán số lượng sản phẩm
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.7)',
                                'rgba(54, 162, 235, 0.7)',
                                'rgba(255, 206, 86, 0.7)',
                                'rgba(75, 192, 192, 0.7)',
                                'rgba(153, 102, 255, 0.7)',
                                'rgba(255, 159, 64, 0.7)'
                            ],
                            borderColor: 'rgba(255, 255, 255, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                position: 'right'
                            }
                        }
                    }
                });
            }
        };

        // Gửi yêu cầu AJAX để lấy dữ liệu từ Servlet
        xhr.open("GET", "categorychart", true);
        xhr.send();
    </script>
</body>
</html>
