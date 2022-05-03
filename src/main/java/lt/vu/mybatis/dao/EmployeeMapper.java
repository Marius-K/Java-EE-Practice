package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Employee;
import org.mybatis.cdi.Mapper;

@Mapper
public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    int insert(Employee row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    List<Employee> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    int updateByPrimaryKey(Employee row);
}