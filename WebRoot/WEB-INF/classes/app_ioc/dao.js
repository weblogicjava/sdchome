var ioc = {
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource" ,
        events : {
            depose : "close"
        },
        fields : {
            driverClassName : "com.mysql.jdbc.Driver",
            url : "jdbc:mysql://127.0.0.1:3306/sdc_app?useUnicode=true&characterEncoding=utf8",
            username : "root",
            password : "root",
			initialSize     : 10,
			maxActive       : 100,
			minIdle         : 10,
			maxIdle         : 20,
			defaultAutoCommit: false,
			validationQuery : "select 1"
        }
    },
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"dataSource"}]
    }
}