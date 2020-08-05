package com.andawell.common.component;

import com.andawell.common.entity.*;
import com.andawell.common.entity.constant.SecurityConstant;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author dcy
 * @date 2019/4/22
 * 将token的验证结果转换用户信息
 */
public class BaseUserAuthenticationConverter implements UserAuthenticationConverter {
    private static final String N_A = "N/A";

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(USERNAME, authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME)) {
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            String username = (String) map.get(USERNAME);
            String id = (String) map.get(SecurityConstant.DETAILS_USER_ID);
            String deptId = (String) map.get(SecurityConstant.DETAILS_DEPT_ID);
            String doorId = (String) map.get(SecurityConstant.DETAILS_DOOR_ID);
            String name = (String) map.get(SecurityConstant.DETAILS_NAME);
            String roleId=(String)map.get(SecurityConstant.DETAILS_ROLE_ID);
            String deptName=(String)map.get(SecurityConstant.DETAILS_DEPT_NAME);
            Set<String> permission = new HashSet<>();

            List<MenuAppPermission> menuAppPermission = new ArrayList<>();
            List<DateDeptPermission> dateDeptPermission = new ArrayList<>();
            List<DatePlanePermission> datePlanePermission = new ArrayList<>();
            List<DateMatePermission> dateMatePermission = new ArrayList<>();
            // 将数据转成json字符串
            JSONObject jsonObject = JSONObject.fromObject(map.get(SecurityConstant.DETAILS_DEFAULT_INVENTORY));
            DefaultInventory defaultInventory = (DefaultInventory) JSONObject.toBean(jsonObject, DefaultInventory.class);

            JSONObject jsonObjectUsable = JSONObject.fromObject(map.get(SecurityConstant.DETAILS_DEFAULT_USABLE_INVENTORY));
            DefaultInventory defaultUsableInventory = (DefaultInventory) JSONObject.toBean(jsonObjectUsable,
                    DefaultInventory.class);
            JSONObject jsonObjectRepair =
                    JSONObject.fromObject(map.get(SecurityConstant.DETAILS_DEFAULT_REPAIR_INVENTORY));
            DefaultInventory defaultRepairInventory = (DefaultInventory) JSONObject.toBean(jsonObjectRepair,
                    DefaultInventory.class);
            JSONObject jsonObjectScrap =
                    JSONObject.fromObject(map.get(SecurityConstant.DETAILS_DEFAULT_SCRAP_INVENTORY));
            DefaultInventory defaultScrapInventory = (DefaultInventory) JSONObject.toBean(jsonObjectScrap,
                    DefaultInventory.class);

            JSONArray jsonArray = JSONArray.fromObject(map.get(SecurityConstant.DETAILS_MENUAPPPERMISSION));
            MenuAppPermission[] menuAppPermissions = (MenuAppPermission[]) JSONArray.toArray(jsonArray, MenuAppPermission.class);
            for (MenuAppPermission menuAppPermission1 : menuAppPermissions) {
                menuAppPermission.add(menuAppPermission1);
            }
            JSONArray jsonArray1 = JSONArray.fromObject(map.get(SecurityConstant.DETAILS_DATEDEPTPERMESSION));
            DateDeptPermission[] dateDeptPermissions = (DateDeptPermission[]) JSONArray.toArray(jsonArray1, DateDeptPermission.class);
            for (DateDeptPermission dateDeptPermission1 : dateDeptPermissions) {
                dateDeptPermission.add(dateDeptPermission1);
            }
            JSONArray jsonArray2 = JSONArray.fromObject(map.get(SecurityConstant.DETAILS_DATEPLANEPERMISSION));
            DatePlanePermission[] datePlanePermissions = (DatePlanePermission[]) JSONArray.toArray(jsonArray2, DatePlanePermission.class);
            for (DatePlanePermission datePlanePermission1 : datePlanePermissions) {
                datePlanePermission.add(datePlanePermission1);
            }
            JSONArray jsonArray3 = JSONArray.fromObject(map.get(SecurityConstant.DETAILS_DATEMATEPERMISSION));
            DateMatePermission[] dateMatePermissions = (DateMatePermission[]) JSONArray.toArray(jsonArray3,
                    DateMatePermission.class);
            for (DateMatePermission dateMatePermission1 : dateMatePermissions) {
                dateMatePermission.add(dateMatePermission1);
            }
            BaseUser user = new BaseUser(id, deptId,deptName,roleId, name, doorId, permission, defaultInventory,
                    defaultUsableInventory, defaultRepairInventory, defaultScrapInventory, menuAppPermission,
                    dateDeptPermission, datePlanePermission, dateMatePermission, username, N_A, true
                    , true, true, true, authorities);
            return new UsernamePasswordAuthenticationToken(user, N_A, authorities);
        }
        return null;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
        Object authorities = map.get(AUTHORITIES);
        if (authorities instanceof String) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
        }
        if (authorities instanceof Collection) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                    .collectionToCommaDelimitedString((Collection<?>) authorities));
        }
        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }

}
