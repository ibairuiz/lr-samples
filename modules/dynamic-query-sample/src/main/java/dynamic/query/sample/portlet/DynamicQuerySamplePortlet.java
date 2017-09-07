package dynamic.query.sample.portlet;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import dynamic.query.sample.constants.DynamicQuerySamplePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduardo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=dynamic-query-sample Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DynamicQuerySamplePortletKeys.DynamicQuerySample,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DynamicQuerySamplePortlet extends MVCPortlet {

	GroupLocalService groupLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Group> sites = new ArrayList();

		DynamicQuery query = groupLocalService.dynamicQuery();

		query.add(PropertyFactoryUtil.forName("site").eq(true));

		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(PropertyFactoryUtil.forName("type").eq(GroupConstants.TYPE_SITE_OPEN));
		disjunction.add(PropertyFactoryUtil.forName("type").eq(GroupConstants.TYPE_SITE_PRIVATE));

		query.add(disjunction);

		sites = groupLocalService.dynamicQuery(query); // query -> SELECT * from GROUP_ WHERE site=TRUE AND (type='1' OR type='3')

		renderRequest.setAttribute("sites", sites);

		super.doView(renderRequest, renderResponse);
	}

	@Reference (unbind = "-")
	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

}