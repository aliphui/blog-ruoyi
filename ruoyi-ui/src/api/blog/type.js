import request from '@/utils/request'

// 查询类型管理列表
export function listType(query) {
  return request({
    url: '/blog/type/list',
    method: 'get',
    params: query
  })
}

// 查询类型管理详细
export function getType(id) {
  return request({
    url: '/blog/type/' + id,
    method: 'get'
  })
}

// 新增类型管理
export function addType(data) {
  return request({
    url: '/blog/type',
    method: 'post',
    data: data
  })
}

// 修改类型管理
export function updateType(data) {
  return request({
    url: '/blog/type',
    method: 'put',
    data: data
  })
}

// 删除类型管理
export function delType(id) {
  return request({
    url: '/blog/type/' + id,
    method: 'delete'
  })
}
