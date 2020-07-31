import request from '@/utils/request'

// 查询销售属性列表
export function listAttribute(query) {
  return request({
    url: '/gds/attribute/list',
    method: 'get',
    params: query
  })
}

// 查询销售属性详细
export function getAttribute(id) {
  return request({
    url: '/gds/attribute/' + id,
    method: 'get'
  })
}

// 新增销售属性
export function addAttribute(data) {
  return request({
    url: '/gds/attribute',
    method: 'post',
    data: data
  })
}

// 修改销售属性
export function updateAttribute(data) {
  return request({
    url: '/gds/attribute',
    method: 'put',
    data: data
  })
}

// 删除销售属性
export function delAttribute(id) {
  return request({
    url: '/gds/attribute/' + id,
    method: 'delete'
  })
}

// 导出销售属性
export function exportAttribute(query) {
  return request({
    url: '/gds/attribute/export',
    method: 'get',
    params: query
  })
}