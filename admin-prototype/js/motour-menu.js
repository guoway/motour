 
$(function(){
    var menu = $('#side-menu') ;
    var menus = [
                '<li class="nav-header">'+
		                 '<div class="dropdown profile-element"> <span>'+
		                         '<img alt="image" class="img-circle" src="img/profile_small.jpg" />'+
		                          '</span>'+
		                     '<a data-toggle="dropdown" class="dropdown-toggle" href="#">'+
		                         '<span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>'+
		                          '</span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>'+
		                     '<ul class="dropdown-menu animated fadeInRight m-t-xs">'+
		                         '<li><a href="profile.html">Profile</a></li>'+
		                         '<li><a href="contacts.html">Contacts</a></li>'+
		                         '<li><a href="mailbox.html">Mailbox</a></li>'+
		                         '<li class="divider"></li>'+
		                         '<li><a href="login.html">Logout</a></li>'+
		                     '</ul>'+
		                 '</div>'+
		                 '<div class="logo-element"> '+
		                     'IN+'+
		                 '</div>'+
		             '</li>'+
		              '<li><a href="main.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span></a></li>',
		              '<li>'+
                    '<a href="javascript:;"><i class="fa fa-diamond"></i> <span class="nav-label">系統管理</span><span class="fa arrow"></span></a>' +
		                '<ul class="nav nav-second-level">'+
		                     '<li><a href="index.html">權限表</a></li>'+
		                     '<li><a href="admin-mgmt.html">管理員維護<span class="label label-primary pull-right">NEW</span></a></li>'+
		                     '<li><a href="dashboard_3.html">網站流量</a></li>'+
		                 '</ul>'+	                    
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">營業查詢</span><span class="fa arrow"></span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="business-report.html">營業報表</a></li>'+
		                     '<li><a href="business-online-orders.html">網路訂單</a></li>'+
		                 '</ul>'+
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-bicycle"></i> <span class="nav-label">車輛管理</span><span class="fa arrow"></span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="car_mgmt.html">車型維護</a></li>'+
		                     '<li><a href="mail_detail.html">車籍資料表</a></li>'+
		                     '<li><a href="mail_compose.html">車輛電池總覽</a></li>'+
		                     '<li><a href="email_template.html">零件管理</a></li>'+
		                 '</ul>'+
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-edit"></i> <span class="nav-label">營業點管理</span><span class="fa arrow"></span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="location-mgmt.html">營業點維護</a></li>'+
		                     '<li><a href="rent-setting-mgmt.html">出租設定</a></li>'+
		                     '<li><a href="rent-description-mgmt.html">租金說明維護</a></li>'+
		                     '<li><a href="service-msg-mgmt.html">服務訊息維護</a></li>'+
		                     '<li><a href="form_editors.html">加購價維護</a></li>'+
		                     '<li><a href="form_editors.html">出車回車</a></li>'+
		                 '</ul>'+
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-desktop"></i> <span class="nav-label">客戶服務</span><span class="fa arrow"></span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="contacts.html">會員資料</a></li>'+
		                     '<li><a href="profile.html">點數設定</a></li>'+
		                     '<li><a href="profile_2.html">影片管理</a></li>'+
		                     '<li><a href="contacts_2.html">營業點評價</a></li>'+
		                 '</ul>'+
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-files-o"></i> <span class="nav-label">行銷管理</span><span class="fa arrow"></span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="search_results.html">企業帳號</a></li>'+
		                 '</ul>'+
		             '</li>',
		             '<li>'+
		                 '<a href="javascript:;"><i class="fa fa-globe"></i> <span class="nav-label">網頁管理</span><span class="label label-info pull-right">NEW</span></a>'+
		                 '<ul class="nav nav-second-level collapse">'+
		                     '<li><a href="toastr_notifications.html">廣告維護</a></li>'+
		                     '<li><a href="nestable_list.html">活動維護</a></li>'+
		                     '<li><a href="agile_board.html">新聞維護</a></li>'+
		                 '</ul>'+
		             '</li>'
];

    for(var i =0;i<menus.length ;i++){
        var item = menus[i]; 
        menu.append(item);
    }
    
 });
 

 
 
 
