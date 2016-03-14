package club.motour.adm.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;
import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.service.Ss3aFunctionService;

import club.motour.model.CodeMeta;
import club.motour.model.Message;
import club.motour.model.ZipCode;
import club.motour.service.UserService;
import club.motour.ui.model.ZipCodeOnUI;
import club.motour.util.CodeMetaUtils;
import club.motour.util.MessageUtils;
import club.motour.util.ZipCodeUtils;

@Controller
public class ConstantDataController extends BaseController {

	@Autowired
	Ss3aFunctionService functionService;
	
	@Autowired
	UserService userService;
	
	/**
	 * 依ID取得Message。
	 * 可傳入變數取代{0},{1}....etc。
	 * @param msgId
	 * @param vars
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getMessage/{msgId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method={RequestMethod.POST})
	public @ResponseBody Message getMessage(String[] vars,@PathVariable String msgId, Model model) {
		return MessageUtils.getInstance().getMessageById(msgId, vars);
	}
	
	/**
	 * 依ID取得CodeMeta
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/getCodeMeta/{cid}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method={RequestMethod.POST})
	public @ResponseBody CodeMeta getCodeMeta(@PathVariable BigDecimal cid) {
		return CodeMetaUtils.getInstance().getCodeMetaById(cid);
	}
	
	/**
	 * 依Parent Cid取得所有子CodeMeta
	 * @param parentCid
	 * @return
	 */
	@RequestMapping(value="/getCodeMetaByParent/{parentCid}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method={RequestMethod.POST})
	public @ResponseBody List<CodeMeta> getCodeMetaByParent(@PathVariable BigDecimal parentCid) {
		return CodeMetaUtils.getInstance().getCodeMetaByParentId(parentCid);
	}
	
	/**
	 * 取得所有郵遞區號。
	 * 格式：100 臺北市中正區
	 * @return
	 */
	@RequestMapping(value="**/getZipCodeList", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method={RequestMethod.GET})
	public @ResponseBody List<ZipCodeOnUI> getZipCodeList() {
		List<ZipCode> list = ZipCodeUtils.getInstance().getAllZipCode();
		List<ZipCodeOnUI> rList = new ArrayList<>();
		for(ZipCode z : list) {
			if(null != z.getParent()) {
				ZipCodeOnUI zu = new ZipCodeOnUI();
				zu.setZip(z.getZip());
				zu.setValue(z.getParent().getName() + z.getName());
				zu.getTokens().add(z.getZip());
				zu.getTokens().add(z.getParent().getName());
				zu.getTokens().add(z.getName());
				rList.add(zu);
			}
		}
		return rList;
	}
	
	@RequestMapping(value="**/getListActions", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(Function.SimpleView.class)
	public @ResponseBody List<Function> getListActions(String parentId) {
		return functionService.getListActions(parentId);
	}
	
	@RequestMapping(value="**/getUserByIdLike", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageResponse getUserByIdLike(String userId, PageRequest pageRequest) {
		PageResponse pr = userService.getUsersByIdLike(userId, pageRequest);
		return pr;
	}
}
