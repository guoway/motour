package club.motour.service;

import com.sylksoft.generic.PageResponse;

import club.motour.search.obj.DispatchMotorSearch;

public interface DispatchMotorService {

	public PageResponse searchForDispatch(DispatchMotorSearch search);
}
