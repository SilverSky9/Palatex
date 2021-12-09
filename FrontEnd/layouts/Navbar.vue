<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-auto p-3 sticky-top bg-dark">
        <fa class="item-link" :icon="['fa', 'eraser']" size="2x" />
      </div>
      <div class="col-sm p-3">sad</div>
    </div>
    <div class="row">
      <div class="col-sm-auto sticky-top">
        <div>
          <ul
            class="
              nav nav-pills nav-flush
              flex-sm-column flex-row flex-nowrap
              mb-auto
              mt-3
              mx-auto
              text-center
              align-items-center
            "
          >
            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Orders"
              >
                <fa class="item-link" :icon="['fa', 'user']" size="2x" />
              </a>
            </li>
            <li class="nav-item">
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Home"
              >
                <fa :icon="['fa', 'chart-bar']" size="2x" />
              </a>
            </li>
            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Dashboard"
              >
                <fa :icon="['fa', 'exchange-alt']" size="2x" />
              </a>
            </li>

            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Products"
              >
                <i class="bi-heart fs-1"></i>
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-sm min-vh-100">
        <Nuxt />
      </div>
    </div>
  </div>
</template>
<style >
.nav-link {
  color: #9f9f9f;
}
.nav-link:hover {
  color: #000;
}
</style>