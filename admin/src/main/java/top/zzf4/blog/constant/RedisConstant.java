package top.zzf4.blog.constant;

// 定义redis常量
public class RedisConstant {
    /**
     * 缓存的数据信息以 dhblog:cache 开头
     */
    // 缓存文章信息
    public static final String CACHE_ARTICLE_ID = "dhBlog:cache:article:";

    // 首页缓存文章列表
    public static final String CACHE_ARTICLE_THUMBNAILS = "dhBlog:cache:article:thumbnails";

    // 七牛云缓存的默认展示图片
    public static final String CACHE_QINIU_DEFAULT_IMAGE = "dhBlog:cache:qiniu:defaultImage";

    // ip缓存信息
    public static final String CACHE_IP = "dhBlog:cache:ip:";

    // ip心跳
    public static final String HEART_IP = "dhBlog:heart:ip:";
    public static final Long EXPIRE_HEART_IP = 10L; // 生存时间十秒

    // 前端展示的数据总览
    public static final String CACHE_OVERVIEW = "dhBlog:cache:overview";

    /**
     * 数据要定时存储到 mysql 中，以 dhblog:schedule 开头
     */
    // 每日的 pv 统计
    public static final String CACHE_DAILY_PV = "dhBlog:schedule:daily:pv:";
}
