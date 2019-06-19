package idv.Day5;

import java.util.List;


public interface EmpDAO_interface {
    public void insert(EmpVO empVO);
    public void update(EmpVO empVO);
    public void delete(int id);
    public EmpVO findByPrimaryKey(int id);
    public List<EmpVO> getAll();

}
