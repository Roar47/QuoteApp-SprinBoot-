package org.example.repository;

import org.example.beans.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public QuoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int getQuotesTableSize(){
        String sql_query = "SELECT count(*) AS row_count FROM quotestable;";
        return jdbcTemplate.queryForObject(sql_query,Integer.class);
    }

    public Quote getQuotebyID(int id){
        String sql_query = "SELECT * FROM quotestable WHERE id = " + id;
        return jdbcTemplate.queryForObject(sql_query,(rs, rowNum) ->
                new Quote(rs.getInt("id"),
                        rs.getString("quote"),
                        rs.getString("author"),
                        rs.getString("language"),
                        rs.getString("category")));
    }


    public Quote getQuotebyCategory(String category) {
        String sql_query = "SELECT * FROM quotestable WHERE category = '" + category + "' ORDER BY RAND() LIMIT 1";
        return jdbcTemplate.queryForObject(sql_query,(rs, rowNum) ->
                new Quote(rs.getInt("id"),
                        rs.getString("quote"),
                        rs.getString("author"),
                        rs.getString("language"),
                        rs.getString("category")));
    }

    public Quote getQuotebyAuthor(String author) {
        String sql_query = "SELECT * FROM quotestable WHERE author = '" + author + "' ORDER BY RAND() LIMIT 1";
        return jdbcTemplate.queryForObject(sql_query,(rs, rowNum) ->
                new Quote(rs.getInt("id"),
                        rs.getString("quote"),
                        rs.getString("author"),
                        rs.getString("language"),
                        rs.getString("category")));
    }
}
