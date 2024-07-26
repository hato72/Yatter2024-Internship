package com.dmm.bootcamp.yatter2024.domain.model

import com.dmm.bootcamp.yatter2024.common.ddd.Entity
import java.net.URL

abstract class Account(
  id: AccountId,
  val username: Username,
  val displayName: String?,
  val note: String?,
  val avatar: URL?,
  val header: URL?,
  val followingCount: Int,
  val followerCount: Int,
  val createdAt: String,
) : Entity<AccountId>(id) {

  abstract suspend fun followings(): List<Account>

  abstract suspend fun followers(): List<Account>
}
