package cn.uc.yiqibang.bean;

public class Provinces {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provinces.id
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provinces.provinceid
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    private String provinceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provinces.province
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    private String province;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provinces.id
     *
     * @return the value of provinces.id
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provinces.id
     *
     * @param id the value for provinces.id
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provinces.provinceid
     *
     * @return the value of provinces.provinceid
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provinces.provinceid
     *
     * @param provinceid the value for provinces.provinceid
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provinces.province
     *
     * @return the value of provinces.province
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provinces.province
     *
     * @param province the value for provinces.province
     *
     * @mbggenerated Fri Nov 10 20:53:12 CST 2017
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}