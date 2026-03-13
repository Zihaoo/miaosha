# API Overview

## App

- `GET /`
  Returns application metadata and a simple runtime status payload.

## Item

- `GET /item/list`
  Returns item list.

- `GET /item/get?id=<id>`
  Returns item detail.

- `GET /item/inspect?id=<id>`
  Returns item detail plus stock and promotion summary fields such as `promoStatus` and `hasActivePromo`.

- `POST /item/create`
  Creates an item.

## User

- `POST /user/getotp`
  Generates and stores a demo OTP in session.

- `POST /user/register`
  Registers a user after OTP validation.

- `POST /user/login`
  Authenticates the user and writes login state to session.

- `GET /user/get?id=<id>`
  Returns user detail.

## Order

- `POST /order/createorder`
  Creates an order for a logged-in user. Supports optional promo order flow.

## Response Format

The project uses a common wrapper:

```json
{
  "status": "success",
  "data": {}
}
```

Error responses return:

```json
{
  "status": "fail",
  "data": {
    "errCode": 10001,
    "errMsg": "参数不合法"
  }
}
```
