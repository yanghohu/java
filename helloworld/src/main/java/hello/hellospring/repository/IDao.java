package hello.hellospring.repository;

import hello.hellospring.domain.ContentVo;

import java.util.ArrayList;

public interface IDao {
    public ArrayList<ContentVo> listDao();
    public void writeDao(String mWriter, String mContent);
    public ContentVo viewDao(String strID);
    public void deleteDao(String bId);
}
