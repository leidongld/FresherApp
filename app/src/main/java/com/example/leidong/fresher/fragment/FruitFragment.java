package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.adapter.ProductsAdapter;
import com.example.leidong.fresher.bean.BannerBean;
import com.example.leidong.fresher.dbbean.Product;
import com.example.leidong.fresher.ui.BannerActivity;
import com.example.leidong.fresher.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class FruitFragment extends BaseFragment {
    private static final String TAG = FruitFragment.class.getSimpleName();

    private Context mContext;

    private View mView;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.recyclerView)
    RecyclerView mFruitsView;

    @BindView(R.id.products_title)
    TextView mProductsTitle;

    List<BannerBean> mBannerList;

    List<Product> mProductList;

    private ProductsAdapter mProductsAdapter;

    @SuppressLint("StaticFieldLeak")
    private static FruitFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private FruitFragment() {

    }

    public static FruitFragment getInstance() {
        if (mInstance == null) {
            synchronized (FruitFragment.class) {
                if (mInstance == null) {
                    mInstance = new FruitFragment();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    /**
     * 全部初始化操作
     */
    @Override
    public void init() {
        initDatas();

        configBanner();

        configFruitsView();
    }

    /**
     * 配置水果列表
     */
    private void configFruitsView() {
        mProductsAdapter = new ProductsAdapter(mContext, mProductList);
        mFruitsView.setLayoutManager(new GridLayoutManager(mContext, 2));
        mFruitsView.setAdapter(mProductsAdapter);
    }

    /**
     * 配置Banner
     */
    private void configBanner() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(BannerBean.getBannerImagesList(mBannerList));
        mBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.setBannerTitles(BannerBean.getBannerTitlesList(mBannerList));
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(3000);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.start();

        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), BannerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("banenr", mBannerList.get(position - 1));
                intent.putExtras(bundle);
                Objects.requireNonNull(getActivity()).startActivity(intent);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        mProductsTitle.setText("精选水果");

        initBannerData();

        initProductData();
    }

    /**
     * 初始化产品数据
     */
    private void initProductData() {
        mProductList = new ArrayList<>();
        mProductList.add(new Product(
                "1",
                "1",
                "007",
                "爱奇果",
                "https://img11.360buyimg.com/n2/jfs/t7873/88/958332640/139857/953e9bc8/599936e5Nb3919bd8.jpg",
                20.00f,
                "陕西眉县 徐香猕猴桃 15个 单果约80~100g"));
        mProductList.add(new Product(
                "2",
                "1",
                "007",
                "丑柑",
                "https://img10.360buyimg.com/n2/jfs/t18676/183/164078159/297786/ea024d8b/5a607804Nae627ab7.jpg",
                30.90f,
                "丑柑 2kg装 单果150~200g"
        ));
        mProductList.add(new Product(
                "3",
                "1",
                "007",
                "苹果",
                "https://img11.360buyimg.com/n2/jfs/t9736/130/2196424951/348309/9e6d671c/59f1a5e3Nf3aa9d8c.jpg",
                33.80f,
                "陕西白水红富士苹果12个 果径70~75mm 总重约2kg"
        ));
        mProductList.add(new Product(
                "4",
                "1",
                "007",
                "蜜柚",
                "https://img14.360buyimg.com/n2/jfs/t3220/28/2650111828/190096/d36bddd4/57e4c912Nf23ee79b.jpg",
                32.80f,
                "特级君溪蜜柚 鸳鸯柚子2粒装 1粒红肉加1粒白肉"
        ));
        mProductList.add(new Product(
                "5",
                "1",
                "007",
                "香梨",
                "https://img11.360buyimg.com/n2/jfs/t8212/335/867296173/346941/42857e6f/59b0afceNd7a1adfa.jpg",
                32.80f,
                "特级库尔勒香梨 单果120~150g 总重量约2.5kg"
        ));
        mProductList.add(new Product(
                "6",
                "1",
                "007",
                "柠檬",
                "https://img11.360buyimg.com/n1/s160x160_jfs/t3073/126/4493743873/517871/e97991e3/5847bf31N86100938.jpg",
                12.90f,
                "黄柠檬4颗"
        ));
        mProductList.add(new Product(
                "7",
                "1",
                "007",
                "小青柠",
                "https://img13.360buyimg.com/n1/s150x150_jfs/t21670/176/97796296/369105/9712110a/5afbd8c3N19b5de1b.jpg",
                16.90f,
                "海南小青柠"
        ));
    }

    /**
     * 初始化Banner信息
     */
    private void initBannerData() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new BannerBean(
                "1",
                "女生最爱，蓝莓の美食",
                "匿名",
                "https://images.pexels.com/photos/70862/pexels-photo-70862.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                "蓝莓，外形可爱，口味酸甜，只看用蓝莓果实炮制的美食，就已经垂涎三尺了。\n" +
                        "\n" +
                        "然而，外形和味道不足够表现蓝莓的完美，它还是一个内涵饱满的果儿。\n" +
                        "蓝莓对消除眼睛疲劳、恢复视力有一定的效果。\n" +
                        "拥有大量“花青素”的蓝莓，具有抗氧化的作用，能够减少皱纹和皮肤老化，还有护肤作用哦。\n" +
                        "此外，因为膳食纤维也很丰富，对排毒也有一定效果哦。\n" +
                        "下次女朋友不舒服，终于可以不说“多喝热水”了，说，“多吃蓝莓”。\n" +
                        "蓝莓原产地在北美州，果实收成期在六月至八月之间，每个果实约2-3g，而今天，蓝莓已遍布世界各地，成为人们喜爱的水果之一。"
        ));
        mBannerList.add(new BannerBean(
                "2",
                "西瓜往事",
                "匿名",
                "https://images.pexels.com/photos/1068534/pexels-photo-1068534.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                "“宁夏西瓜，便宜啦！一块钱一斤！”大大小小的喇叭里，传来带着点地方口音的普通话叫卖声。\n" +
                        "\n" +
                        "这声音一下子把我的记忆拉回了二十多年前。\n" +
                        "\n" +
                        "那时候，家里人多，地也多。除了种小麦玉米等粮食作物，不时地还会种些棉花、大豆、西瓜等经济作物。其中就数西瓜种得最频繁，几乎不隔年。\n" +
                        "\n" +
                        "那时候，我最喜欢家里种西瓜了，因为那样就可以不受限制地吃西瓜。在那个零食很贫乏的时代，西瓜、桃子、杏等这些水果，可是孩子们的最爱呢。\n" +
                        "\n" +
                        "记得我三舅地里有几棵葡萄，有一次我去的时候，正赶上他们已经摘过了，剩下的都不太熟。可是难得来一次，怎么能不吃就回去呢？结果，那天晚上吃饭的时候，我连豆腐都咬不动！\n" +
                        "\n" +
                        "我喜欢种西瓜还有一个原因是可以借着看瓜的名义和小伙伴疯玩或者静静地看书。\n" +
                        "\n" +
                        "当西瓜个头稍大一些的时候，大人就会在地头搭一个简单结实的棚子，铺上铺盖，谓之瓜棚或瓜庵。然后家里人轮流白天黑夜地在地里看护西瓜，以防有人偷瓜。\n" +
                        "\n" +
                        "我因为年龄小，又是女孩子，所以被安排在白天看瓜。早上吃过早饭，我要赶到地里去换晚上看瓜的哥哥或爸爸回来。\n" +
                        "\n" +
                        "我是个安静不下来的人，一路走着，一路不安分。捡一根粗细合适的棍子，走着抡着，把路一边的草“斩首示众”。心里还想着等下午回去的时候，把另一边的也同样对待。现在想想，小草何辜，却被我摧残？\n" +
                        "\n" +
                        "看瓜的时候，有时候会约上小伙伴，大家一起到地头去玩。捉迷藏、石头剪刀布刮鼻子、斗草，什么都玩。渴了饿了，就到地里装模作样地敲几下，挑个瓜杀开大家一起吃。因为挑瓜方法没掌握，也会遇到半生不熟的，那就偷偷扔远点，再挑。\n" +
                        "\n" +
                        "因为大家家里都比较忙，所以不是什么时候小伙伴都有空的。没人玩的时候，我最喜欢一个人静静地看书。也没有什么书可看，就是看哥哥姐姐的中学语文课本。直到现在，我都觉得以前的课本真好看，什么《牛郎织女》啊，什么《连升三级》啊，有趣好玩，印象深刻。\n" +
                        "\n" +
                        "种瓜当然要卖瓜。一般提前一天摘好、装车，第二天一大早就拉着架子车去卖。也有人串村卖，我们一般是到市里去卖，因为我们村离市里还算不太远，而且村里有瓜的人家不用买，没钱买的又多，生意就不好做。\n" +
                        "\n" +
                        "去市里卖瓜差不多需要一天时间，所以我们会带上干粮。中午就找个树荫，啃点干粮，吃口西瓜，一顿饭就对付过去了。\n" +
                        "\n" +
                        "西瓜行情好的时候，能卖到三五毛一斤，行情不好的时候，才几分钱一斤，一车几百斤西瓜，爷几个辛苦一天，才不过几十元。现在呢，一个西瓜有时候都得几十元。这通货膨胀的有点吓人啊！\n" +
                        "\n" +
                        "种西瓜的时候很辛苦，但可以吃西瓜，也算不错。不种西瓜的时候，犯了馋怎么办？有串村卖瓜的呀！\n" +
                        "\n" +
                        "我记得那时候，是可以用麦子换西瓜、杏的。每当有人吆喝“麦换杏”或“麦换西瓜”的时候，我们正在看场的小朋友，就选一些大人没有收拾干净的麦子，去换自己想吃的杏或西瓜。\n" +
                        "\n" +
                        "有时候，我们去打猪草。碰到一块已经下了园的西瓜地，就会进去搜罗一番，运气好的时候，也会找到几个小小的“漏网之鱼”，高高兴兴地“大快朵颐”。\n" +
                        "\n" +
                        "那时候的西瓜，怎么就那么甜呢？"
        ));
        mBannerList.add(new BannerBean(
                "3",
                "橘子的味道",
                "匿名",
                "https://images.pexels.com/photos/207085/pexels-photo-207085.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                "小时候最爱吃橘子，本地的水土养不活这样酸甜的植物。每到秋收时节，有卡车开来，村人便拿着一袋袋的稻谷去换一篓篓橘子苹果梨，我家换来的多是橘子。爸爸爱吃，我也爱。\n" +
                        "\n" +
                        "那一年的橘子换回来，有一只大得稀奇，记忆中它仿佛一只小柚子静静的躺在篓底。它是最大的，所以也是最好的。当一个个橘子吃完，谁也没有动它，因为爸爸说了，这个橘子是留给我的。那个秋天，空气里的橘子香一直飘逸不散，我一直在期翼，期翼那个留给我的橘子。\n" +
                        "\n" +
                        "日子终于到了，仿佛朝圣般的心情，拨开，月牙儿一般的瓣儿围坐如小拳。取一片，初嚼无味，再细细嚼去，仍是寡淡。\n" +
                        "\n" +
                        "很多年后，我都记得那种失望的心情。已经挤压变坏的瓤瓣，在日久期盼的心情里，散发出一种腐败的气味。很多年后，每当经过橘子摊时，我常常会说对同学说，知道吗，我曾吃过一个像柚子大的橘子，但我不曾说的是那种不应属于橘子的味道。\n" +
                        "\n" +
                        "那是父母眼里最好的东西，他们节省着预留着，放在一日日的时光里，去掉了所有过程里的苦难与痛苦，用一种疼爱的眼神说，孩子，来，过一种只有甜的生活。\n" +
                        "\n" +
                        "但是生活是不可以预判的，每个人都活在各自的经历当中，而这种经历又不可避免的成为他们看世界的局限性。\n" +
                        "\n" +
                        "我曾经受过的我不想你在经受，我曾经想要的，孩子，我希望你可以得到。\n" +
                        "\n" +
                        "外婆13岁失去了母亲，在外婆的记忆里总是十三岁的那个冬天，撬开冰面，刚刚没有妈妈的女孩穿着破棉袄一边洗被单一边绝望哭泣，没有吃食，看着别家院子里米粥的香，只能抱着年幼的妹妹强忍饥饿。于是幼年时的妈妈，总看到外婆坐在油灯前，一针一线的纳着鞋样子，给孩子们做千层底的布鞋。再穷的日子，的确良的花褂子，二斤红糖蘸着油渣子，妈妈编着双辫子，打村前走过，成了外婆眼里的骄傲。\n" +
                        "\n" +
                        "妈妈三次中考没考过，很偶然的机会看到她中学时的物理笔记本，娟秀的字迹在扉页写着“明日复明日，明日何其多，日日待明日，万事成蹉跎”。夏天，怕有蚊子，别人在外面乘凉，她把脚放在水桶中，一夜，煤油灯把鼻尖照得漆黑。于是幼年的我，尚且3岁，便开始识字读书，在那个不重学业的乡村里，我日日夜夜被灌输的都是“吃得苦中苦方为人上人”，没有爱好，也没有玩伴，第一名是妈妈脸上的骄傲。\n" +
                        "\n" +
                        "而现在你是否也为自己的人生抱憾，自幼喜爱画画，但是当母亲看到我的画作时，先是夸奖继而又想想起什么是的，劈头说道，不要做这些歪门邪道，马上要考试了，好好读书才是要紧。于是长大后的你，在心理默默说，以后我的孩子有什么潜力我一定让她尽情发挥，我所不能拥有的快乐，就让她来拥有吧。\n" +
                        "\n" +
                        "外婆挨饿受冻，所以她认为温饱才是最大的幸福，于是她给了妈妈衣物和食物;妈妈没能完成中考，所以她认为成绩才是最大的幸福，于是她将一切心力都放在我的考试上。我没能做自己爱做的事情，所以我认为兴趣才是最大的幸福，于是。。。。。。\n" +
                        "\n" +
                        "我们都坚定不移的认为自己所预判的道路一定是最好的，因为那是我们不曾得到的幸福，所以孩子，你应该快乐，你应该知足。但是作为孩子的你，你幸福吗？\n" +
                        "\n" +
                        "三四岁，去池塘抓蝌蚪，放在装爽生粉的铁盒当中，清水惯养着，那样污浊的河水，我趴在茶几上看蝌蚪，心想，小蝌蚪，你原来的生活的环境那么脏，现在应该和快乐吧，在这样清洁的水中自由游泳。于是，自得溢满的自己总沉静在一种给与的满足感中。\n" +
                        "\n" +
                        "但是，蝌蚪死了，刚刚长出的四肢安安静静的蜷缩着，飘在清澈空明的水面上，如浮萍。\n" +
                        "\n" +
                        "我始终相信给与的那一刻，是宠溺，是爱，是心疼，是力所能及所能给与的最好的。但人生的难以琢磨，让我们常常迷失在岔路口。不去设定，不去判断，播下一颗希望的种子，培养一种成长的力量，等到有一天，他长到足够高时，让他去树下摘下他自己想要的那只。\n" +
                        "\n" +
                        "也许它不够好，不够甜，但终是属于自己的橘子。\n"
        ));
        mBannerList.add(new BannerBean(
                "你所不知道的牛油果",
                "4",
                "匿名",
                "https://images.pexels.com/photos/557659/pexels-photo-557659.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                "牛油果可能是世界上最完美的食物。你可以把它们混入意酱粉，烤馅饼和我们的最爱--把牛油果切成玫瑰。同时，它们还富含抗氧化剂,维生素C,维生素E和保湿脂肪，对你的皮肤和头发能够发挥奇效。\n" +
                        "\n" +
                        "\n" +
                        "1.面膜和体膜\n" +
                        "\n" +
                        "当然，你可以把蜂蜜，蛋清或者酸奶当做面膜使用。但是现在我要告诉你一个简单的方法:把一个成熟的牛油果切一半，在脸上和胸口涂上厚厚的一层，等待15分钟后冲洗干净。每周做一次，你的肌肤就会看起来水嫩光滑。\n" +
                        "\n" +
                        "\n" +
                        "2.发膜\n" +
                        "\n" +
                        "在碗里捣碎半个鳄梨，再加上半个柠檬汁和一点橄榄油。在你干燥的头发上涂抹混合物，然后用毛巾包住头部。敷在面上大约20分钟，然后再用水冲洗掉。每周重复一次，头发就会看起来柔顺许多。\n" +
                        "\n" +
                        "\n" +
                        "3.眼霜\n" +
                        "\n" +
                        "维生素C是眼部精华素里一种非常常见的成分。因此，毫无疑问，每只眼睛冷敷鳄梨片15分钟，是消除黑眼圈的好方法。所以快试试吧!\n" +
                        "\n" +
                        "\n" +
                        "4.手部磨砂膏\n" +
                        "\n" +
                        "在碗里拌匀搅拌半个鳄梨和两小勺粗盐。再把混合物擦在手上，轻揉皮肤两分钟，然后在用水冲洗掉。去角质的同时可以有效去除死皮细胞并滋润皮肤。\n" +
                        "\n" +
                        "\n" +
                        "5.晒伤膏\n" +
                        "\n" +
                        "如果在今年夏天在游泳池边花了太多时间，那就捣烂些许牛油果，让它敷在灼伤部位15分钟。根据需要反复涂抹，但重中之重还是要记得涂抹防晒霜。\n"
        ));
        mBannerList.add(new BannerBean(
                "每个人都有想要吃的葡萄",
                "5",
                "匿名",
                "https://images.pexels.com/photos/197907/pexels-photo-197907.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350",
                "今年暑假出去玩，是我一直心心念念的事。说实话，每个人都有他自己想做的事。有些人如愿以偿了，有些人只能在理想和现实之中挣扎，最后无奈的接受现实。很不幸，我是后者。\n" +
                        "\n" +
                        "我出生在不算富裕的农村家庭，在我很小的时候，爸妈就因为家里的经济原因经常吵架。后来，我妈赌气但是更多的也是为了家庭生计外出打工去了。\n" +
                        "\n" +
                        "一个人跟爸爸在一起生活是一段异常难熬的时光。爸爸是一个寡言少语的人，对我却是异常严格。我也经常通过提高对自己的要求，更好的完成爸爸给我的任务来让爸爸开心，结果往往收效甚微。印象中爸爸总是那副严肃的面孔，仿佛从来就没见他笑过，当然那只是在我面前。不过即使这样爸爸还是我的偶像，因为他总是能轻而易举的完成我认为很难完成的事情。\n" +
                        "\n" +
                        "妈妈过早的外出打工，爸爸对我的严格要求，让我早早的就体验到了生活的艰辛。这也让我变得更加坚强，但是也多了一份敏感。小时候我印象中我很少流过泪。这也在很大程度上让我成为一个容易感动的人，现在生活中的一些小事总是能让我感动的泪流满面。其实当困难来临，你自己一个人面对，没有人倾诉，没有人关心，你可能会怕，但你是绝对不会哭的，因为你知道，就算你哭也没有人看的到，你会亮出你的盔甲坚强面对。最怕的是朋友突然的关心，所有受过的委屈一股脑的流出来，盔甲变成了软肋，泪如泉涌。\n" +
                        "\n" +
                        "后来，迫于生计我爸和我妈一起出去打工了。我跟奶奶生活在一起，那应该是我童年中最自由自在无忧无虑的一段时间了吧！我有一群志同道合的小伙伴，我们一起横行霸道欺负别人。上学放学回家的路上我们都是打打闹闹的，开开心心的。我应该高兴那时候还没有城市农村之分。\n" +
                        "\n" +
                        "再到后来，我去了城里读书，读的是寄宿学校。刚去城里，城市的高楼大厦，路上的车水马龙，再向你诉说着城市的繁华，你是可以感受的到的。可是呆久了之后也就慢慢习惯了，不再为高楼大厦抬头凝视，不再为路上的车水马龙彳亍不前。没有对比就没有伤害，这倒是真的。每当我从学校回家，自己是个农村人是刻在身上的印记，是消不掉的。看着那几座红砖房横在那里，周围草木丛生。\n" +
                        "\n" +
                        "直到大学，我来到了一个算得上真正的城市——武汉。我才发现自己真的算是井底之蛙，同学叫我去酒吧，去看电影，去蹦迪。这些东西我长这么大一样也没有做过。但是我慢慢适应，慢慢让自己变得像个城里人。可是每次跟父母的通话，听着他们的诉苦都让我落入了无底深渊，难以自拔。\n" +
                        "\n" +
                        "朋友们在一起聊天的时候，总有一些家境还不错的朋友开玩笑说，真希望自己是个富二代啊!我从来都不说，因为我没有底气说。每次听到他们这样说的时候，我只是尴尬的笑一笑，好像自己是一个富二代一样来掩饰自己心中的卑微。有时候朋友们闲聊，有的说我现在只想怎么挣钱，我说我感觉自己挣不了大钱，开开心心的就好啦！可是仔细想想一个没有钱的人，想做什么都不能做，怎么能开心呢？\n" +
                        "\n" +
                        "聊了这么多，是时候该回归主题了。这个暑假本来是想打算出去玩的，但是没钱，只能在外面搬砖。看着朋友们一个个去这玩去那玩，国内玩，国外玩。旅游，看偶像演唱会，心里是酸酸的。\n" +
                        "\n" +
                        "每个人都有都有想要吃的葡萄，我心心念念的暑假出去玩，在那些暑假到处玩的人来说，就像每天吃饭一样平常。上次在网上看到一个家境贫寒的学生以理科707分的高分考上北大。她的作文是感恩贫穷。其实仔细想想贫穷给了我们贫穷的苦难，福贵给了我们福贵的体验，都应该被感恩。\n" +
                        "\n" +
                        "至于自己想吃的葡萄，只有通过自己的努力，才会更香甜。\n"
        ));
    }
}
