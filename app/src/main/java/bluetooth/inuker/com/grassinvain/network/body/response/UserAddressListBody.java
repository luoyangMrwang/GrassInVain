package bluetooth.inuker.com.grassinvain.network.body.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 1 on 2017/4/13.
 */

public class UserAddressListBody implements Serializable {

    public String  endRow;
    public String  hasNextPage;
    public String  pages;
    public String  pageNum;
    public String  lastPage;
    public Object  navigatepageNums;
    public String  isLastPage;
    public String  total;
    public String  nextPage;
    public String  navigatePages;
    public String  size;
    public String  hasPreviousPage;
    public String  startRow;
    public String  prePage;
    public List<AddressDetailBody> list;
    public String  firstPage;
    public String  isFirstPage;
    public String  pageSize;

}
