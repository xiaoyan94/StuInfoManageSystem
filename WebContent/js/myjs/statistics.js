/**
 * 
 */
function refresh_echart() {
	        $.ajax({
	    	    "url" : "${pageContext.request.contextPath}/statisticsAction_goingJson",
//    	    "data" : {
//    	      "id" : id
//    	    },
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('获取到'+data.length+"条数据", 2000, 'rounded')
	    	init_echart(data);
	    },
	    "async" : true//false 同步请求
	});
}
function refresh_echart2() {
    $.ajax({
	    "url" : "${pageContext.request.contextPath}/statisticsAction_goingJson",
//    	    "data" : {
//    	      "id" : id
//    	    },
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('获取到'+data.length+"条数据", 2000, 'rounded')
	    	
	    	init_echart2(data);
	    },
	    "async" : true//false 同步请求
	});
}
function refresh_echart3() {
    $.ajax({
	    "url" : "${pageContext.request.contextPath}/statisticsAction_goingAddressJson",
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('获取到'+data.data.length+"条数据", 2000, 'rounded');
	    	init_echart3(data);
	    },
	    "async" : true//false==>同步请求
	});
}

function init_echart(json){
	var dom = document.getElementById('echart');
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
	    title : {
	        text: '校外学生去向分布统计',
	        subtext: '实时数据',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: ['实习','实训','工作','其他','休假']
	    },
	    series : [
	        {
	            name: '去向分布',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:json,
// 	            data:[
//	                {value:25, name:'实习'},
//	                {value:20, name:'实训'},
//	                {value:14, name:'工作'},
//	                {value:5, name:'其他'}
//	            ], 
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.8)'
	                }
	            }
	        }
	    ]
	};
	if (option && typeof option === "object") {
	    myChart.setOption(option, true);
	    myChart.on('click', function(param) {
	        console.log(param.data.name);
	        $.ajax({
	    		"url" : "${pageContext.request.contextPath}/goingAction_getGoingRecordsByGoingName",
	    		"data":{
	    			name:param.data.name
	    		},
	    		"dataType" : "json",
	    		"success" : function(data) {
	    			if(data.status == 'success'){
	    				$('#student_going_table').empty();
	    				for(var i=0;i<data.data.length;i++){
	    					$('#student_going_table').append(`
	    					<tr>
	    			            <td>${data.data[i]['student.id']}</td>
	    			            <td>${data.data[i]['student.name']}</td>
	    						<td>${data.data[i]['student.sex']}</td>
	    			            <td>${data.data[i]['student.tel']}</td>
	    						<td>${data.data[i]['student.classes']}</td>
	    						<td>${data.data[i]['student.profession']}</td>
	    						<td>${data.data[i]['student.college']}</td>
	    			            <td>${data.data[i].going}</td>
	    			            <td>${data.data[i].workName}</td>
	    			            <td>${data.data[i].workAddress}</td>
	    			            <td>${data.data[i].workLinkmanName}</td>
	    			            <td>${data.data[i].workTel}</td>
	    			          </tr>
	    					`);
	    				}
	    				$('#student_going_modal').modal('open');
	    			}
	    		},
	    		"async" : true//false 同步请求
	    	});
	        //var url = param.data.url;
	        //window.location.href = url;
	    });
	    
	}

	
}
function init_echart2(json){
	var dom = document.getElementById('echart2');
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    title : {
        text: '学生考勤统计扇形图',
    subtext: '今日签到情况分布',
    x:'center'
},
tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
    orient: 'vertical',
    left: 'left',
    data: ['已签到','未签到']
},
series : [
    {
        name: '人数统计',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
        data:json,
        /* data:[
            {value:25, name:'已签到'},
            {value:20, name:'未签到'}
        ], */
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.8)'
                }
            }
        }
    ]
};
if (option && typeof option === "object") {
myChart.setOption(option, true);
myChart.on('click', function(param) {
    //console.log(param);
    var name = param.data.name;
    if(name=='已签到'){
    	Materialize.toast('刷新今日已签到学生列表', 4000, 'rounded');
        $('#yiqiandao').modal('open');
    }else if(name=='未签到'){
    	Materialize.toast('刷新今日未签到学生列表', 4000, 'rounded');
        $('#weiqiandao').modal('open');
//        $('#p').text('111');
    }
    //window.location.href = url;
});
	}
}
		function init_echart3(json){
			var dom = document.getElementById("echart3_bar");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	app.title = '柱状图';
	
	option = {
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : json.xAxis,
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'人数',
	            type:'bar',
	            barWidth: '60%',
	            data:json.data
	        }
	    ]
	};
	if (option && typeof option === "object") {
	    myChart.setOption(option, true);
	    myChart.on('click',function(param){
	    	console.log(param.name);
	    	$.ajax({
	    		"url" : "${pageContext.request.contextPath}/goingRecordAction_getGoingRecordsByAddress",
	    		"data":{
	    			workAddress:param.name
	    		},
	    		"dataType" : "json",
	    		"success" : function(data) {
	    			if(data.status == 'success'){
	    				$('#student_going_table').empty();
	    				for(var i=0;i<data.data.length;i++){
	    					$('#student_going_table').append(`
	    					<tr>
	    			            <td>${data.data[i]['student.id']}</td>
	    			            <td>${data.data[i]['student.name']}</td>
	    						<td>${data.data[i]['student.sex']}</td>
	    			            <td>${data.data[i]['student.tel']}</td>
	    						<td>${data.data[i]['student.classes']}</td>
	    						<td>${data.data[i]['student.profession']}</td>
	    						<td>${data.data[i]['student.college']}</td>
	    			            <td>${data.data[i].going}</td>
	    			            <td>${data.data[i].workName}</td>
	    			            <td>${data.data[i].workAddress}</td>
	    			            <td>${data.data[i].workLinkmanName}</td>
	    			            <td>${data.data[i].workTel}</td>
	    			          </tr>
	    					`);
	    				}
	    				$('#student_going_modal').modal('open');
	    			}
	    		},
	    		"async" : true//false 同步请求
	    	});
	    });
	}
}
function refresh_timecards(){
	json = [
        {value:25, name:'已签到'},
        {value:20, name:'未签到'}
    ];
	$.ajax({
		"url" : "${pageContext.request.contextPath}/timecardAction_getSignedStudents",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status == 'success'){
				json[0].value=data.students.length;
				$('#yiqiandao_table').empty();
				for(var i=0;i<json[0].value;i++){
					$('#yiqiandao_table').append(`
					<tr>
			            <td>${data.students[i].id}</td>
			            <td>${data.students[i].name}</td>
						<td>${data.students[i].sex}</td>
			            <td>${data.students[i].tel}</td>
			            <td>${data.students[i].goingName}</td>
			            <td>${data.students[i].workName}</td>
			            <td>${data.students[i].workAddress}</td>
			            <td>${data.students[i].workLinkmanName}</td>
			            <td>${data.students[i].workTel}</td>
			          </tr>
					`);
				}
			}
		},
		"async" : false//false 同步请求
	});
	$.ajax({
		"url" : "${pageContext.request.contextPath}/timecardAction_getUnsignedStudents",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status == 'success'){
				json[1].value=data.students.length;
				$('#weiqiandao_table').empty();
				for(var i=0;i<json[1].value;i++){
					$('#weiqiandao_table').append(`
					<tr>
			            <td>${data.students[i].id}</td>
			            <td>${data.students[i].name}</td>
			            <td>${data.students[i].sex}</td>
						<td>${data.students[i].tel}</td>
			            <td>${data.students[i].goingName}</td>
			            <td>${data.students[i].workName}</td>
			            <td>${data.students[i].workAddress}</td>
			            <td>${data.students[i].workLinkmanName}</td>
			            <td>${data.students[i].workTel}</td>
			          </tr>
					`);
				}
			}
			
			Materialize.toast('获取到'+data.students.length+"条数据", 2000, 'rounded')
		},
		"async" : false//false 同步请求
	});
//	while(json[1].f==true&&json[0].f==true){
		init_echart2(json);
//	}
}