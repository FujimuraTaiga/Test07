public class NoticeBoardDAO{
    private final JdbcTemplate jdbcTemplate;

    public NoticeBoardDAO(JdbcTeplate jdbcTeplate){this.jdbcTemplate = jdbcTemplate;}

    public void createPost(ThreadPost post){
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("thread_post");
        insert.execute(param);
    }

    public List<ThreadPost> readPost(String threadId){
        String query = "SELECT * FROM thread_post WHERE threadId = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query,threadId);

        List<ThreadPost> threadPosts = result.stream()
                .map((Map<String,Object> row) -> new ThreadPost(
                        row.get("postId").toString(),
                        row.get("threadId").toString(),
                        row.get("comment").toString()
                )).toList();

        return threadPosts;
    }

    public List<Thread> readThread(){
        String query = "SELECT * FROM thread";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        List<CafeteriaMenu> cafeteriaMenus = result.stream()
                .map((Map<String,Object> row) -> new CafeteriaMenu(
                        row.get("id").toString(),
                        row.get("threadName").toString(),
                )).toList();

        return thread;
    }


    createThread(){}        //スレッド情報（id,スレッド名）をDB(thread)に登録する。
    readThread(){}           //スレッド情報（id,スレッド名）をDB(thread)から読み取る。
    createPost(){}            //投稿情報(投稿Id,スレッドId,コメント)をDB(thread_post)に登録する。
    readPost(){}               //投稿情報をDB(投稿Id,スレッドId,コメント)をDB(thread_post)から読み取る。
}