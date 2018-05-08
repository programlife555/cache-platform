$(function(){
    getClusterListInfo(function(obj){
        var clusterListInfo = obj.res;
        $("#cluster-number").text(clusterListInfo.clusterNumber);
        $("#cluster-ok-number").text(clusterListInfo.clusterOkNumber);
        $("#cluster-fail-number").text(clusterListInfo.clusterFailNumber);
        updateWarningCount();
        $('.my-list-panel-header').eq(0).find("a").trigger("click");;
    })

})

function updateWarningCount(){
    listCluster(function(obj){
        var clusterIds = [];
        var clusters = obj.res;
        clusters.forEach(function(element){
            clusterIds.push(element.id);
        });
        countTotalAlarm(clusterIds, function(obj){
            $("#cluster-alarm-count").text(obj.res);
        });
    });
}

smarty.get( "/user/listGroup", "monitor/monitor_list", "group-classify", function(){
   /* console.log("get...");*/
}, true );



$(document).on("click", ".list-active", function(res){
    var group = $(this).data("group");
    var isOpen = $(this).attr("aria-expanded");
    smarty.get( "/cluster/listCluster?group=" + group, "monitor/cluster_info_list", "group-id-" + group, function(obj){
        $(".cluster-info-detail-" + group).click();
    }, true );
});

$(document).on("click", ".cluster-info-detail", function(res){
    var clusterId = $(this).data("cluster-id");
    var address = $(this).data("cluster-address");
    smarty.get( "/cluster/getClusterInfoByAddress?address=" + address, "monitor/cluster_info", "cluster-info-" + clusterId, function(obj){
       countWarningLogByClusterId(clusterId, function(obj){
            $("#cluster-alarm-" + clusterId).text( obj.res );
       });
    }, true );
});


