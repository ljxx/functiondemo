package www.function.com.functiondemo.ui.function;

import android.os.Bundle;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.function.com.functiondemo.R;
import www.function.com.functiondemo.base.BaseActivity;

/**
 * 百度地图
 */
public class BaiduMapActivity extends BaseActivity {

    private BaiduMap mBaiduMap;

    @BindView(R.id.custom_text)
    TextView customText;
    @BindView(R.id.bmapView)
    MapView bmapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);
        ButterKnife.bind(this);
        customText.setText("百度地图");

        mBaiduMap = bmapView.getMap();
        /**
         * 设置地图类型
         */

        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL); //普通类型地图

//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE); //卫星类型地图

//        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE); //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。

        /**
         * 开启交通路况图
         */
//        mBaiduMap.setTrafficEnabled(true);

        /**
         * 开启城市热力地图
         */
//        mBaiduMap.setBaiduHeatMapEnabled(true);

        /**
         * 设置地图标注
         */
        /*LatLng point = new LatLng(31.12, 121.53); //定义mark坐标点
        BitmapDescriptor mBitmap = BitmapDescriptorFactory.fromResource(R.drawable.point); //构建mark标注
        OverlayOptions mOptions = new MarkerOptions().position(point).icon(mBitmap); //构建MarkerOption，用于在地图上添加Marker
        mBaiduMap.addOverlay(mOptions); //在地图上添加Marker，并显示*/

        /**
         * 设置室内地图
         */
        mBaiduMap.setIndoorEnable(true);
        mBaiduMap.setOnBaseIndoorMapListener(new BaiduMap.OnBaseIndoorMapListener() {
            @Override
            public void onBaseIndoorMapMode(boolean b, MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
                if (b) {
                    System.out.println("进入室内图");
                    // 进入室内图
                    // 通过获取回调参数 mapBaseIndoorMapInfo 来获取室内图信息，包含楼层信息，室内ID等
                } else {
                    // 移除室内图
                    System.out.println("移除室内图");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        bmapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        bmapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        bmapView.onPause();
    }
}
