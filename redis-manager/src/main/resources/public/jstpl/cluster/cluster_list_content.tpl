<ul>
    {{if $code == 0 }}
        {{foreach from=$res item=cluster}}
            <li data="{{$cluster.clusterName}}">
                    <div class="cluster-item">
                        <div class="delete-container" data-cluster-id="{{$cluster.id}}">
                            <i class="material-icons">close</i>
                        </div>
                        <a href="/pages/redisMonitorDetail" class="to-detail" title="see cluster detail">
                            <div class="one-data">
                                <span><b>{{$cluster.clusterName}}</b></span>
                            </div>
                            <div class="one-data" id="cluster-state-{{$cluster.id}}">
                                <b>{{cluster_state address=$cluster.address id=$cluster.id}}</b>
                            </div>
                            <div class="one-data">
                                <span>Group:&nbsp</span>
                                <span><b>{{$cluster.userGroup}}</b></span>
                            </div>
                            <div class="one-data">
                                <span>Address:&nbsp</span>
                                <span><b>{{$cluster.address}}</b></span>
                            </div>
                        </a>
                        <div class="operation-btn-swapper">
                            <!-- 后期需要带参 -->
                            <a href="/cluster/clusterManager?clusterId={{$cluster.id}}" class="operation-btn">
                                <span data-cluster-id="{{$cluster.id}}">Manager</span>
                            </a>
                        </div>
                    </div>
                </li>
        {{/foreach}}
    {{/if}}
    <li class="add-li" title="import cluster">
        <div class="add-btn">
            <i class="glyphicon glyphicon-plus"></i>
        </div>
    </li>
</ul>