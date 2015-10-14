package cn.tyshan.rest.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import cn.tyshan.rest.resource.CampaignGenerateResource;
import cn.tyshan.rest.resource.MessageResource;
import cn.tyshan.rest.resource.UserGenerateResource;
import cn.tyshan.rest.resource.UserRequestResource;

/**
 * Jersey configure injection rest resource
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(RequestContextFilter.class);
		register(MessageResource.class);
		register(UserRequestResource.class);
		register(CampaignGenerateResource.class);
		register(UserGenerateResource.class);
		register(JacksonFeature.class);
		register(LoggingFilter.class);
	}
}