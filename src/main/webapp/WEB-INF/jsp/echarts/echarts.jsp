<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECharts</title>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <form action="">
    <div id="main" style="height:400px"></div>
    </form>
    
    
    <!-- ====================>Placed at the end of the document so the pages load faster 放置在文档末尾，网页加载更快 -->
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist',
                baseUrl:'${pageContext.request.contextPath}'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
            	//ec 的自有属性
                /* var propertys = Object.getOwnPropertyNames(ec);
                console.log(propertys.length); 
                console.log(propertys.join("\n")); 
                console.log((typeof ec.version)+':'+ec.version);
                console.log((typeof ec.dependencies)+':'+ec.dependencies);
                console.log((typeof ec.init)+':'+ec.init);
                console.log((typeof ec.getInstanceById )+':'+ec.getInstanceById ); */
                var ecConfig = require('echarts/config');
                console.log(ecConfig.EVENT.DATA_VIEW_CHANGED);
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['销量']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"销量",
                            "type":"bar",
                            "data":[5, 20, 40, 10, 10, 20]
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
				require(['baseUrl/js/dark'], function(tarTheme){
				    myChart.setTheme(tarTheme);
				});
            }
        );
    </script>
</body>
</html>