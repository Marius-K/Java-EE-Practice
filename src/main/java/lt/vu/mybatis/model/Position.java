package lt.vu.mybatis.model;

public class Position {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.POSITION.ID
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.POSITION.NAME
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.POSITION.ID
     *
     * @return the value of PUBLIC.POSITION.ID
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.POSITION.ID
     *
     * @param id the value for PUBLIC.POSITION.ID
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.POSITION.NAME
     *
     * @return the value of PUBLIC.POSITION.NAME
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.POSITION.NAME
     *
     * @param name the value for PUBLIC.POSITION.NAME
     *
     * @mbg.generated Tue May 03 08:19:10 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}